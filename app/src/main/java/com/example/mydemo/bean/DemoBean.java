package com.example.mydemo.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @Author yinfx
 * @Date 2018/11/9
 * @Description
 */
public class DemoBean implements Serializable {


    /**
     * time : 2018-11-11
     * list : [{"id":"1037","title":"土耳其原装进口雍家玉米油","pics":["http://112.13.199.14:202/uploads/products/201806/5b3085d67f794.jpg","http://112.13.199.14:202/uploads/products/201806/5b3085e2617a8.jpg","http://112.13.199.14:202/uploads/products/201806/5b3085ea0b48d.jpg"],"price":"98.00","stock":"200","sells":"0","state":"1","hits":"12","addtime":"1541664959"}]
     */

    private String time;
    private List<ListBean> list;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * id : 1037
         * title : 土耳其原装进口雍家玉米油
         * pics : ["http://112.13.199.14:202/uploads/products/201806/5b3085d67f794.jpg","http://112.13.199.14:202/uploads/products/201806/5b3085e2617a8.jpg","http://112.13.199.14:202/uploads/products/201806/5b3085ea0b48d.jpg"]
         * price : 98.00
         * stock : 200
         * sells : 0
         * state : 1
         * hits : 12
         * addtime : 1541664959
         */

        private String id;
        private String title;
        private String price;
        private String stock;
        private String sells;
        private String state;
        private String hits;
        private String addtime;
        private List<String> pics;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getStock() {
            return stock;
        }

        public void setStock(String stock) {
            this.stock = stock;
        }

        public String getSells() {
            return sells;
        }

        public void setSells(String sells) {
            this.sells = sells;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getHits() {
            return hits;
        }

        public void setHits(String hits) {
            this.hits = hits;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public List<String> getPics() {
            return pics;
        }

        public void setPics(List<String> pics) {
            this.pics = pics;
        }
    }
}
