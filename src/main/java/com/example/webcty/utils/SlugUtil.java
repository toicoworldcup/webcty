package com.example.webcty.utils;

import com.github.slugify.Slugify;

public class SlugUtil {
    public static String generateSlug(String title) {
        Slugify slugify = Slugify.builder().build();
        return slugify.slugify(title);
    }
}