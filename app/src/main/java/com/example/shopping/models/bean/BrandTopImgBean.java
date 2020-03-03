package com.example.shopping.models.bean;

public class BrandTopImgBean {

    /**
     * errno : 0
     * errmsg :
     * data : {"brand":{"id":1001002,"name":"内野制造商","list_pic_url":"http://yanxuan.nosdn.127.net/8ca3ce091504f8aa1fba3fdbb7a6e351.png","simple_desc":"严选从世界各地挑选毛巾，最终选择了为日本内野代工的工厂，追求毛巾的柔软度与功能性。品质比肩商场几百元的毛巾。","pic_url":"http://yanxuan.nosdn.127.net/e50654982984206b54e9226e5ab7f90c.jpg","sort_order":10,"is_show":1,"floor_price":29,"app_list_pic_url":"http://yanxuan.nosdn.127.net/8ca3ce091504f8aa1fba3fdbb7a6e351.png","is_new":0,"new_pic_url":"","new_sort_order":10}}
     */

    private int errno;
    private String errmsg;
    private DataBean data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * brand : {"id":1001002,"name":"内野制造商","list_pic_url":"http://yanxuan.nosdn.127.net/8ca3ce091504f8aa1fba3fdbb7a6e351.png","simple_desc":"严选从世界各地挑选毛巾，最终选择了为日本内野代工的工厂，追求毛巾的柔软度与功能性。品质比肩商场几百元的毛巾。","pic_url":"http://yanxuan.nosdn.127.net/e50654982984206b54e9226e5ab7f90c.jpg","sort_order":10,"is_show":1,"floor_price":29,"app_list_pic_url":"http://yanxuan.nosdn.127.net/8ca3ce091504f8aa1fba3fdbb7a6e351.png","is_new":0,"new_pic_url":"","new_sort_order":10}
         */

        private BrandBean brand;

        public BrandBean getBrand() {
            return brand;
        }

        public void setBrand(BrandBean brand) {
            this.brand = brand;
        }

        public static class BrandBean {
            /**
             * id : 1001002
             * name : 内野制造商
             * list_pic_url : http://yanxuan.nosdn.127.net/8ca3ce091504f8aa1fba3fdbb7a6e351.png
             * simple_desc : 严选从世界各地挑选毛巾，最终选择了为日本内野代工的工厂，追求毛巾的柔软度与功能性。品质比肩商场几百元的毛巾。
             * pic_url : http://yanxuan.nosdn.127.net/e50654982984206b54e9226e5ab7f90c.jpg
             * sort_order : 10
             * is_show : 1
             * floor_price : 29
             * app_list_pic_url : http://yanxuan.nosdn.127.net/8ca3ce091504f8aa1fba3fdbb7a6e351.png
             * is_new : 0
             * new_pic_url :
             * new_sort_order : 10
             */

            private int id;
            private String name;
            private String list_pic_url;
            private String simple_desc;
            private String pic_url;
            private int sort_order;
            private int is_show;
            private String floor_price;
            private String app_list_pic_url;
            private int is_new;
            private String new_pic_url;
            private int new_sort_order;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getList_pic_url() {
                return list_pic_url;
            }

            public void setList_pic_url(String list_pic_url) {
                this.list_pic_url = list_pic_url;
            }

            public String getSimple_desc() {
                return simple_desc;
            }

            public void setSimple_desc(String simple_desc) {
                this.simple_desc = simple_desc;
            }

            public String getPic_url() {
                return pic_url;
            }

            public void setPic_url(String pic_url) {
                this.pic_url = pic_url;
            }

            public int getSort_order() {
                return sort_order;
            }

            public void setSort_order(int sort_order) {
                this.sort_order = sort_order;
            }

            public int getIs_show() {
                return is_show;
            }

            public void setIs_show(int is_show) {
                this.is_show = is_show;
            }

            public String getFloor_price() {
                return floor_price;
            }

            public void setFloor_price(String floor_price) {
                this.floor_price = floor_price;
            }

            public String getApp_list_pic_url() {
                return app_list_pic_url;
            }

            public void setApp_list_pic_url(String app_list_pic_url) {
                this.app_list_pic_url = app_list_pic_url;
            }

            public int getIs_new() {
                return is_new;
            }

            public void setIs_new(int is_new) {
                this.is_new = is_new;
            }

            public String getNew_pic_url() {
                return new_pic_url;
            }

            public void setNew_pic_url(String new_pic_url) {
                this.new_pic_url = new_pic_url;
            }

            public int getNew_sort_order() {
                return new_sort_order;
            }

            public void setNew_sort_order(int new_sort_order) {
                this.new_sort_order = new_sort_order;
            }
        }
    }
}
