/*
 * This class is used to parse usersXml.xml, extract user information and
 * compare it to data from user input. If valid, print to console that user
 * is longged in and if this user is admin, print to console a list of
 * all users in database and their information
 */
package verifyxml;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author George
 */
public class parseUsersXml {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //input from scanner a username and password
        String username;
        String password;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input username: ");
        username = scanner.nextLine().toLowerCase();
        System.out.println("Please input password: ");
        password = scanner.nextLine();
        
        try {
            //filepath to xml database
            File inputFile = new File("D:\\NetBeans8_2\\Java6RotaruGeorge\\Java6RotaruGeorge\\src\\verifyxml\\usersXml.xml");
            //instantiate the factory
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            //get instance of a builder and parse the xml file
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(inputFile);
            //reducing redundancies
            doc.getDocumentElement().normalize();
            //set root element
            NodeList nList = doc.getElementsByTagName("user");
            //create a map to add user list and user information
            Map<String, List<String>> map = new LinkedHashMap<>();
            Boolean validUserAdmin = false;
            Boolean validNormalUser = false;
            String validUser = "";
            //iterate through nodes
            for (int temp=0; temp<nList.getLength(); temp++){
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE){
                    Element eElement = (Element) nNode;
                    String userXml = eElement.getElementsByTagName("userID").item(0).getTextContent().toLowerCase();
                    //add key to map
                    map.put(userXml, new LinkedList<>());
                    String userXmlCnp = eElement.getElementsByTagName("CNP").item(0).getTextContent();
                    String userXmlIsAdmin = eElement.getElementsByTagName("isAdmin").item(0).getTextContent();
                    //assign values to key
                    map.get(userXml).add(userXmlCnp);
                    map.get(userXml).add(userXmlIsAdmin);
                    Boolean userIsAdmin = Boolean.parseBoolean(userXmlIsAdmin);
                    String userXmlPasswd = eElement.getElementsByTagName("passwd").item(0).getTextContent(); 
                    //test if inputed username and password are in database
                    if (username.equals(userXml) && password.equals(userXmlPasswd)){
                        //test if user logged in has admin role
                        if (userIsAdmin){
                            validUserAdmin = true;
                            validUser = userXml;
                        } else {
                            validNormalUser = true;
                            validUser = userXml;
                        }
                    }
                }
            }
            //display information if user logged in is not admin
            if (validNormalUser) {
                System.out.println("*************************************");
                System.out.println("User "+validUser+" log in successful!");
            //display list of users and information if user logged in is admin
            } else if (validUserAdmin) {
                System.out.println("*************************************");
                System.out.println("User "+validUser+"(admin) log in successful!");
                System.out.println("\nHere is a list of all users:");;
                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    System.out.println("username: "+entry.getKey());
                    System.out.println("\tCNP: "+entry.getValue().get(0));
                    System.out.println("\tadmin credentials: "+entry.getValue().get(1));
                }
            //display if wrong credentials are inputed
            } else {
                System.out.println("Bad username or password!");
            }      
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(parseUsersXml.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }   
}
