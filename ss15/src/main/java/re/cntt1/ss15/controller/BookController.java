package re.cntt1.ss15.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import re.cntt1.ss15.service.IBookService;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class BookController {

    private final IBookService bookService;

    @GetMapping
    public String home(
            Model model,
            @RequestParam(name = "search", defaultValue = "") String search,
//            // Trang hiện tại bắt đầu từ 0
//            @RequestParam(name = "page",defaultValue = "0") Integer page,
//            // Số lượng phần tử của 1 trang
//            @RequestParam(name = "size",defaultValue = "3") Integer size
            @PageableDefault(
                    page = 0,
                    size = 3,
                    sort = "id",
                    direction = Sort.Direction.ASC
            ) Pageable pageable
    ) {

//        Pageable pageable = PageRequest.of(page,size);

        model.addAttribute(
                "books",
                bookService.getAllManga(search, pageable)
        );

        /**
         * Page<Book> gồm:
         *      content: danh sách phần tủ của 1 trang hiện tại
         *      totalElements: Tổng số phần tử
         *      totalPages: Tổng số trang
         *      number: trang hiện tại (bắt đầu từ 0)
         * */
        return "library";
    }

}
