/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

/**
 *
 * @author George
 * @param <K>
 * @param <V>
 */
public interface Pair<K, V> {
    public K getKey();
    public V getValue();
}
