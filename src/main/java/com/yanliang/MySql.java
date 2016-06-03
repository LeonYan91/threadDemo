package com.yanliang;
;import org.apache.ibatis.jdbc.SQL;

/**
 * @author yanliang
 * @ClassName MySql
 * @Description
 * @Date 2016/5/24
 */
public class MySql{




    public String test(){
        SQL s = new SQL(){
            {
                SELECT("");
            }
        };

        return new InnerMySql().toString();
    }

    private class InnerMySql extends SQL{
        {
            SELECT("name");
        }
    }
}
