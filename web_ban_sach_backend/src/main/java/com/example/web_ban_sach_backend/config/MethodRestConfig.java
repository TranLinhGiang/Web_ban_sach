package com.example.web_ban_sach_backend.config;

import com.example.web_ban_sach_backend.model.NguoiDung;
import com.example.web_ban_sach_backend.model.TheLoai;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MethodRestConfig implements RepositoryRestConfigurer {
    // Cấu hình cho phép ngăn chặn các phương thức
    private String url = "http://http://localhost:8080/";

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
        // trong này cho phép chặn hoặc các method
        HttpMethod[] chanCacPhuongThuc = {
                HttpMethod.POST,
                HttpMethod.PUT,
                HttpMethod.DELETE,
                HttpMethod.PATCH
        };
        // ví dụ chặn các phương thức thêm, sửa xóa, cập nhật đối với thể loại:
        disableHttpMethod(TheLoai.class, config, chanCacPhuongThuc);

        // ví dụ chặn người dùng không cho người dùng sử dụng được phương thức delete Start
        HttpMethod[] phuongThucDelete = {
                HttpMethod.DELETE
        };
        disableHttpMethod(NguoiDung.class, config, phuongThucDelete);
    }
    // ví dụ chặn người dùng không cho người dùng sử dụng được phương thức delete End


    private void disableHttpMethod(Class c, RepositoryRestConfiguration repositoryRestConfiguration,
                                   HttpMethod[] methods) {
        repositoryRestConfiguration.getExposureConfiguration()
                .forDomainType(c)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(methods))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(methods));
    }
}
