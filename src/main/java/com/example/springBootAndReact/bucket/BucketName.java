package com.example.springBootAndReact.bucket;

public enum BucketName {
    IMAGE_BUCKET("test");
    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName () {
        return bucketName;
    }

}
