package com.example.shopping.models.bean;

import java.util.List;

public class ZhuantiBean {
    /**
     * data : {"count":20,"currentPage":1,"data":[{"id":314,"price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14943267735961674.jpg","subtitle":"专业运动品牌同厂，毛毛虫鞋买二送一","title":"关爱他成长的每一个足迹"},{"id":313,"price_info":59.9,"scene_pic_url":"https://yanxuan.nosdn.127.net/14942996754171334.jpg","subtitle":"这些就是他们想要的礼物清单","title":"一次解决5个节日送礼难题"},{"id":300,"price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14939843143621089.jpg","subtitle":"前段时间有朋友跟我抱怨，和婆婆住到一起才发现生活理念有太多不和。别的不提，光是洗...","title":"秒杀化学洗涤剂的纯天然皂"},{"id":299,"price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14938873919030679.jpg","subtitle":"许多人经历过旅途中内裤洗晾不便的烦恼，尤其与旅伴同居一室时，晾在卫生间里的内裤更...","title":"买过的人都说它是差旅神器"},{"id":295,"price_info":35.8,"scene_pic_url":"https://yanxuan.nosdn.127.net/14938092956370380.jpg","subtitle":"多款商品直减中，最高直减400元","title":"他们在严选遇见的新生活"},{"id":294,"price_info":149,"scene_pic_url":"https://yanxuan.nosdn.127.net/14937214454750141.jpg","subtitle":"买100年传世珐琅锅送迷你马卡龙色小锅","title":"这只锅，可以从祖母用到孙辈"},{"id":291,"price_info":29,"scene_pic_url":"https://yanxuan.nosdn.127.net/14939496197300723.jpg","subtitle":"如何挑选适合自己的好物？","title":"舒适新主张"},{"id":289,"price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14932840600970609.jpg","subtitle":"越来越多运动人士意识到，运动鞋要购置好的，鞋里的运动袜也不可忽视。专业运动袜帮助...","title":"专业运动袜也可以高性价比"},{"id":287,"price_info":29.9,"scene_pic_url":"https://yanxuan.nosdn.127.net/14931970965550315.jpg","subtitle":"一种软装一个家","title":"严选新式样板间"},{"id":286,"price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14931121822100127.jpg","subtitle":"大家都知道，饮食组是严选体重最重的一组，基本上每个新人都能在一个月之内迅速长胖。...","title":"无\u201c油\u201d无虑的甜蜜酥脆"}],"pageSize":10,"totalPages":2}
     * errmsg :
     * errno : 0
     */

    private DataBeanX data;
    private String errmsg;
    private int errno;

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public static class DataBeanX {
        /**
         * count : 20
         * currentPage : 1
         * data : [{"id":314,"price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14943267735961674.jpg","subtitle":"专业运动品牌同厂，毛毛虫鞋买二送一","title":"关爱他成长的每一个足迹"},{"id":313,"price_info":59.9,"scene_pic_url":"https://yanxuan.nosdn.127.net/14942996754171334.jpg","subtitle":"这些就是他们想要的礼物清单","title":"一次解决5个节日送礼难题"},{"id":300,"price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14939843143621089.jpg","subtitle":"前段时间有朋友跟我抱怨，和婆婆住到一起才发现生活理念有太多不和。别的不提，光是洗...","title":"秒杀化学洗涤剂的纯天然皂"},{"id":299,"price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14938873919030679.jpg","subtitle":"许多人经历过旅途中内裤洗晾不便的烦恼，尤其与旅伴同居一室时，晾在卫生间里的内裤更...","title":"买过的人都说它是差旅神器"},{"id":295,"price_info":35.8,"scene_pic_url":"https://yanxuan.nosdn.127.net/14938092956370380.jpg","subtitle":"多款商品直减中，最高直减400元","title":"他们在严选遇见的新生活"},{"id":294,"price_info":149,"scene_pic_url":"https://yanxuan.nosdn.127.net/14937214454750141.jpg","subtitle":"买100年传世珐琅锅送迷你马卡龙色小锅","title":"这只锅，可以从祖母用到孙辈"},{"id":291,"price_info":29,"scene_pic_url":"https://yanxuan.nosdn.127.net/14939496197300723.jpg","subtitle":"如何挑选适合自己的好物？","title":"舒适新主张"},{"id":289,"price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14932840600970609.jpg","subtitle":"越来越多运动人士意识到，运动鞋要购置好的，鞋里的运动袜也不可忽视。专业运动袜帮助...","title":"专业运动袜也可以高性价比"},{"id":287,"price_info":29.9,"scene_pic_url":"https://yanxuan.nosdn.127.net/14931970965550315.jpg","subtitle":"一种软装一个家","title":"严选新式样板间"},{"id":286,"price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14931121822100127.jpg","subtitle":"大家都知道，饮食组是严选体重最重的一组，基本上每个新人都能在一个月之内迅速长胖。...","title":"无\u201c油\u201d无虑的甜蜜酥脆"}]
         * pageSize : 10
         * totalPages : 2
         */

        private int count;
        private int currentPage;
        private int pageSize;
        private int totalPages;
        private List<DataBean> data;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 314
             * price_info : 0
             * scene_pic_url : https://yanxuan.nosdn.127.net/14943267735961674.jpg
             * subtitle : 专业运动品牌同厂，毛毛虫鞋买二送一
             * title : 关爱他成长的每一个足迹
             */

            private int id;
            private Float price_info;
            private String scene_pic_url;
            private String subtitle;
            private String title;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Float getPrice_info() {
                return price_info;
            }

            public void setPrice_info(Float price_info) {
                this.price_info = price_info;
            }

            public String getScene_pic_url() {
                return scene_pic_url;
            }

            public void setScene_pic_url(String scene_pic_url) {
                this.scene_pic_url = scene_pic_url;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
