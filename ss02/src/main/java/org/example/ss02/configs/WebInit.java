package org.example.ss02.configs;

import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?> @Nullable [] getRootConfigClasses() {
        return new Class[0];
    }

    // Liệt kê các lớp cấu hình ở đây
    @Override
    protected Class<?> @Nullable [] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    // Cấu hình đường dẫn request sẽ đi qua
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
