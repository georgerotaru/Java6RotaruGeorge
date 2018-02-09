INSERT INTO AUTHORS VALUES ('4656666726579', 'Jeffrey', 'Young');
INSERT INTO AUTHORS VALUES ('4616657420532', 'Janet', 'Klosko');

INSERT INTO EBOOKS VALUES ('978-606-40-0212-9', 'Cum s?-?i reinventezi via?a', '?i se întâmpl? adesori s? pui nevoile celorlal?i mai presus de ale tale? Te panichezi când persoana iubit? te amenin?? c? te p?r?se?te? Te temi în mod exagerat de boli ?i de e?ecuri financiare? E?ti ve?nic nemul?umit, în ciuda reu?itelor personale ?i profesionale?', 'ePub', 472, 'other', 24.99);

INSERT INTO EBOOK_AUTHORS(ISBN, CNP) VALUES ('978-606-40-0212-9', '4656666726579');
INSERT INTO EBOOK_AUTHORS(ISBN, CNP) VALUES ('978-606-40-0212-9', '4616657420532');

INSERT INTO EBOOK_RATINGS(RATING, CNP, ISBN) VALUES ('***', 'pacurar', '978-606-40-0212-9');