package com.bookingticket.controller.config.CloudinaryConfig;


import com.cloudinary.Cloudinary;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.cloudinary.utils.ObjectUtils;

public class CloudinaryConfig {
    private String cloud_name = "dpgnm1bdi";
    private String api_key = "692925454987215";
    private String api_secret = "YPYpy0ecEItH-tKyt1vU7dRs3eg";

    static String CLOUDINARY_URL = "cloudinary://692925454987215:YPYpy0ecEItH-tKyt1vU7dRs3eg@dpgnm1bdi";

    static Cloudinary cloudinary = new Cloudinary(CLOUDINARY_URL);

    public void upload() {
        try {
            Map params1 = ObjectUtils.asMap(
                    "use_filename", true,
                    "unique_filename", false,
                    "overwrite", true
            );
            cloudinary.uploader().upload("https://cloudinary-devs.github.io/cld-docs-assets/assets/images/coffee_cup.jpg", params1);
            ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        Cloudinary c = CloudinaryConfig.cloudinary;
        System.out.println(c.uploader().upload("https://i.pinimg.com/736x/42/79/dd/4279dd7bb35d713388ed6569ef0c555e.jpg", null));
    }
}
