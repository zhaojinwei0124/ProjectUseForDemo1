package data;

import java.util.List;

/**
 * Created by qiush on 2016/8/26.
 */
public class UserInfo {
    /**
     * error_code : 200
     * state : success
     * count : 2
     * result : [{"icon":"http://host:8080/info/hjt.jpg","name":"胡锦涛","pwd":123},{"icon":"http://host:8080/info/xjp.jpg","name":"习近平","pwd":456}]
     */

    public int error_code;
    public String state;
    public int count;
    /**
     * icon : http://host:8080/info/hjt.jpg
     * name : 胡锦涛
     * pwd : 123
     */

    public List<ResultBean> result;

    public static class ResultBean {
        public String icon;
        public String name;
        public int pwd;
    }
}
