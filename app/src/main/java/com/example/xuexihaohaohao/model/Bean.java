package com.example.xuexihaohaohao.model;

import java.util.List;

public class Bean {
    private List<BeanResult> result;

    public List<BeanResult> getResult() {
        return result;
    }

    public void setResult(List<BeanResult> result) {
        this.result = result;
    }
    public  class  BeanResult{
        String imageUrl;
        String  name;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
