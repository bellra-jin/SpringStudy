package com.bellrajin.section01.autowired.common;

import java.util.List;

public interface BookDAO {

    List<BookDTO> findAllBooks();

    BookDTO findBookBySeq(int seq);

}
