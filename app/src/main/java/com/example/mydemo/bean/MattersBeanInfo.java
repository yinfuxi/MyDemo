package com.example.mydemo.bean;

import java.util.List;

/**
 *   理财产品的实体类
 */
public class MattersBeanInfo {


    /**
     * regularDtoList : [{"haveCastAmount":"0.00","limitDay":"150","prodName":"测试产品定期","prodStatus":"1","raiseAmount":"5000000.00","raiseRate":"0","rate":"8","surplusAmount":"5000000.00","prodId":"10000000000001","prodType":"1","prodKind":"1","baseRate":"9","floatRate":"1.5"}]
     * count : 4
     * pageSize : 4
     */

    public String count;
    private String pageSize;
    private List<RegularDtoListBean> regularDtoList;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public List<RegularDtoListBean> getRegularDtoList() {
        return regularDtoList;
    }

    public void setRegularDtoList(List<RegularDtoListBean> regularDtoList) {
        this.regularDtoList = regularDtoList;
    }

    @Override
    public String toString() {
        return "MattersBeanInfo{" +
                "count='" + count + '\'' +
                ", pageSize='" + pageSize + '\'' +
                ", regularDtoList=" + regularDtoList +
                '}';
    }

    public static class RegularDtoListBean {
        /**
         * haveCastAmount : 0.00
         * limitDay : 150
         * prodName : 测试产品定期
         * prodStatus : 1
         * raiseAmount : 5000000.00
         * raiseRate : 0
         * rate : 8
         * surplusAmount : 5000000.00
         * prodId : 10000000000001
         * prodType : 1
         * prodKind : 1
         * baseRate : 9
         * floatRate : 1.5
         */

        private String haveCastAmount;
        private String limitDay;
        private String prodName;
        private String prodStatus;
        private String raiseAmount;
        private String raiseRate;
        private String rate;
        private String surplusAmount;
        private String prodId;
        private String prodType;
        private String prodKind;
        private String baseRate;
        private String floatRate;

        public String getHaveCastAmount() {
            return haveCastAmount;
        }

        public void setHaveCastAmount(String haveCastAmount) {
            this.haveCastAmount = haveCastAmount;
        }

        public String getLimitDay() {
            return limitDay;
        }

        public void setLimitDay(String limitDay) {
            this.limitDay = limitDay;
        }

        public String getProdName() {
            return prodName;
        }

        public void setProdName(String prodName) {
            this.prodName = prodName;
        }

        public String getProdStatus() {
            return prodStatus;
        }

        public void setProdStatus(String prodStatus) {
            this.prodStatus = prodStatus;
        }

        public String getRaiseAmount() {
            return raiseAmount;
        }

        public void setRaiseAmount(String raiseAmount) {
            this.raiseAmount = raiseAmount;
        }

        public String getRaiseRate() {
            return raiseRate;
        }

        public void setRaiseRate(String raiseRate) {
            this.raiseRate = raiseRate;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getSurplusAmount() {
            return surplusAmount;
        }

        public void setSurplusAmount(String surplusAmount) {
            this.surplusAmount = surplusAmount;
        }

        public String getProdId() {
            return prodId;
        }

        public void setProdId(String prodId) {
            this.prodId = prodId;
        }

        public String getProdType() {
            return prodType;
        }

        public void setProdType(String prodType) {
            this.prodType = prodType;
        }

        /**
         * 新增产品类型标识 <br/></>
         * 1 新手标<br/></>
         * 2 得利宝<br/></>
         * 3 得信宝<br/></>
         * 4 得智宝<br/></>
         * 5 得慧宝<br/>
         * 6 得盈宝<br/>
         */
        public String getProdKind() {
            return prodKind;
        }

        public void setProdKind(String prodKind) {
            this.prodKind = prodKind;
        }

        public String getBaseRate() {
            return baseRate;
        }

        public void setBaseRate(String baseRate) {
            this.baseRate = baseRate;
        }

        public String getFloatRate() {
            return floatRate;
        }

        public void setFloatRate(String floatRate) {
            this.floatRate = floatRate;
        }

        @Override
        public String toString() {
            return "RegularDtoListBean{" +
                    "haveCastAmount='" + haveCastAmount + '\'' +
                    ", limitDay='" + limitDay + '\'' +
                    ", prodName='" + prodName + '\'' +
                    ", prodStatus='" + prodStatus + '\'' +
                    ", raiseAmount='" + raiseAmount + '\'' +
                    ", raiseRate='" + raiseRate + '\'' +
                    ", rate='" + rate + '\'' +
                    ", surplusAmount='" + surplusAmount + '\'' +
                    ", prodId='" + prodId + '\'' +
                    ", prodType='" + prodType + '\'' +
                    ", prodKind='" + prodKind + '\'' +
                    ", baseRate='" + baseRate + '\'' +
                    ", floatRate='" + floatRate + '\'' +
                    '}';
        }
    }
}
