package com.epsoft.tessreact.java8.util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

/**
 * DK10
 * @author 
 */

public class Dk10 implements Serializable,Comparable<Dk10> {

    private	String	aac002  ;	//	身份证号码
    private	String	dkc011	;	//	审核结果
    private	Date	dkc010	;	//	银行部门审核日期
    private	String	dkc012	;	//	银行部门发放意见
    private	Date	dkc100	;	//	合同开始日期
    private	Date	dkc101	;	//	合同结束日期
    private	Date	dkc102	;	//	贷款发放日期
    private	Double	dkc103	;	//	发放金额
    private	Double	dkc107	;	//	放款年利率%
    private	String	dkc204	;	//	贷款合同号
    private	String	dkc201	;	//	贷款批次号
    private	String	dka076	;	//	还款方式
    private	String	dkc009	;	//	经办人姓名
    private	String	dka013	;	//	贷款期限（月）
    private	String	aae011	;	//	经办人姓名
    private	Double	dka032	;	//	实际还款(本金)
    private	Double	dka034	;	//	应该还款(本金)
    private	Double	dka071	;	//	个人承担利息
    private	Date	dka033	;	//	还款日期
    private	Date	dka036	;	//	还款经办日期
    private	String	aac003	;	//	姓名
    private	String	dka030	;	//	贷款类型
    private	String	acc300	;	//	贷款编号
    private	String	aab301	;	//	贷款编号
    private	Double	dkc104	;	//	已贴息金额
    private String  message ;   //  返回信息
    private String  success ;   //  结果（成功1/失败0）
    private String  dkc232  ;   //  贴息发放账户（银行+分行+行号）对应dk02表
    private String  dkc230  ;   //  贷款银行账户编码（银行+分行+行号），需要各地维护自己的贷款银行，对应dk02表
    private String  dka023  ;   //  贷款金额
    private String  aae008  ;   //  贷款银行
    private String  dka224  ;   //  银行审核意见(1合格，满足贷款条件) (0不满足贷款条件)

    public Dk10() {

    }

    public String getAac002() {
        return aac002;
    }

    public void setAac002(String aac002) {
        this.aac002 = aac002;
    }

    public String getDkc011() {
        return dkc011;
    }

    public void setDkc011(String dkc011) {
        this.dkc011 = dkc011;
    }

    public Date getDkc010() {
        return dkc010;
    }

    public void setDkc010(Date dkc010) {
        this.dkc010 = dkc010;
    }

    public String getDkc012() {
        return dkc012;
    }

    public void setDkc012(String dkc012) {
        this.dkc012 = dkc012;
    }

    public Date getDkc100() {
        return dkc100;
    }

    public void setDkc100(Date dkc100) {
        this.dkc100 = dkc100;
    }

    public Date getDkc101() {
        return dkc101;
    }

    public void setDkc101(Date dkc101) {
        this.dkc101 = dkc101;
    }

    public Date getDkc102() {
        return dkc102;
    }

    public void setDkc102(Date dkc102) {
        this.dkc102 = dkc102;
    }

    public Double getDkc103() {
        return dkc103;
    }

    public void setDkc103(Double dkc103) {
        this.dkc103 = dkc103;
    }

    public Double getDkc107() {
        return dkc107;
    }

    public void setDkc107(Double dkc107) {
        this.dkc107 = dkc107;
    }

    public String getDkc204() {
        return dkc204;
    }

    public void setDkc204(String dkc204) {
        this.dkc204 = dkc204;
    }

    public String getDkc201() {
        return dkc201;
    }

    public void setDkc201(String dkc201) {
        this.dkc201 = dkc201;
    }

    public String getDka076() {
        return dka076;
    }

    public void setDka076(String dka076) {
        this.dka076 = dka076;
    }

    public String getDkc009() {
        return dkc009;
    }

    public void setDkc009(String dkc009) {
        this.dkc009 = dkc009;
    }

    public String getDka013() {
        return dka013;
    }

    public void setDka013(String dka013) {
        this.dka013 = dka013;
    }

    public String getAae011() {
        return aae011;
    }

    public void setAae011(String aae011) {
        this.aae011 = aae011;
    }

    public Double getDka032() {
        return dka032;
    }

    public void setDka032(Double dka032) {
        this.dka032 = dka032;
    }

    public Double getDka034() {
        return dka034;
    }

    public void setDka034(Double dka034) {
        this.dka034 = dka034;
    }

    public Double getDka071() {
        return dka071;
    }

    public void setDka071(Double dka071) {
        this.dka071 = dka071;
    }

    public Date getDka033() {
        return dka033;
    }

    public void setDka033(Date dka033) {
        this.dka033 = dka033;
    }

    public Date getDka036() {
        return dka036;
    }

    public void setDka036(Date dka036) {
        this.dka036 = dka036;
    }

    public String getAac003() {
        return aac003;
    }

    public void setAac003(String aac003) {
        this.aac003 = aac003;
    }

    public String getDka030() {
        return dka030;
    }

    public void setDka030(String dka030) {
        this.dka030 = dka030;
    }

    public String getAcc300() {
        return acc300;
    }

    public void setAcc300(String acc300) {
        this.acc300 = acc300;
    }

    public String getAab301() {
        return aab301;
    }

    public void setAab301(String aab301) {
        this.aab301 = aab301;
    }

    public Double getDkc104() {
        return dkc104;
    }

    public void setDkc104(Double dkc104) {
        this.dkc104 = dkc104;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getDkc232() {
        return dkc232;
    }

    public void setDkc232(String dkc232) {
        this.dkc232 = dkc232;
    }

    public String getDkc230() {
        return dkc230;
    }

    public void setDkc230(String dkc230) {
        this.dkc230 = dkc230;
    }

    public String getDka023() {
        return dka023;
    }

    public void setDka023(String dka023) {
        this.dka023 = dka023;
    }

    public String getAae008() {
        return aae008;
    }

    public void setAae008(String aae008) {
        this.aae008 = aae008;
    }

    public String getDka224() {
        return dka224;
    }

    public void setDka224(String dka224) {
        this.dka224 = dka224;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dk10 dk10 = (Dk10) o;
        return Objects.equals(aac002, dk10.aac002) &&
                Objects.equals(dkc011, dk10.dkc011) &&
                Objects.equals(dkc010, dk10.dkc010) &&
                Objects.equals(dkc012, dk10.dkc012) &&
                Objects.equals(dkc100, dk10.dkc100) &&
                Objects.equals(dkc101, dk10.dkc101) &&
                Objects.equals(dkc102, dk10.dkc102) &&
                Objects.equals(dkc103, dk10.dkc103) &&
                Objects.equals(dkc107, dk10.dkc107) &&
                Objects.equals(dkc204, dk10.dkc204) &&
                Objects.equals(dkc201, dk10.dkc201) &&
                Objects.equals(dka076, dk10.dka076) &&
                Objects.equals(dkc009, dk10.dkc009) &&
                Objects.equals(dka013, dk10.dka013) &&
                Objects.equals(aae011, dk10.aae011) &&
                Objects.equals(dka032, dk10.dka032) &&
                Objects.equals(dka034, dk10.dka034) &&
                Objects.equals(dka071, dk10.dka071) &&
                Objects.equals(dka033, dk10.dka033) &&
                Objects.equals(dka036, dk10.dka036) &&
                Objects.equals(aac003, dk10.aac003) &&
                Objects.equals(dka030, dk10.dka030) &&
                Objects.equals(acc300, dk10.acc300) &&
                Objects.equals(aab301, dk10.aab301) &&
                Objects.equals(dkc104, dk10.dkc104) &&
                Objects.equals(message, dk10.message) &&
                Objects.equals(success, dk10.success) &&
                Objects.equals(dkc232, dk10.dkc232) &&
                Objects.equals(dkc230, dk10.dkc230) &&
                Objects.equals(dka023, dk10.dka023) &&
                Objects.equals(aae008, dk10.aae008) &&
                Objects.equals(dka224, dk10.dka224);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aac002, dkc011, dkc010, dkc012, dkc100, dkc101, dkc102, dkc103, dkc107, dkc204, dkc201, dka076, dkc009, dka013, aae011, dka032, dka034, dka071, dka033, dka036, aac003, dka030, acc300, aab301, dkc104, message, success, dkc232, dkc230, dka023, aae008, dka224);
    }

    @Override
    public String toString() {
        return "Dk10{" +
                "aac002='" + aac002 + '\'' +
                ", dkc011='" + dkc011 + '\'' +
                ", dkc010=" + dkc010 +
                ", dkc012='" + dkc012 + '\'' +
                ", dkc100=" + dkc100 +
                ", dkc101=" + dkc101 +
                ", dkc102=" + dkc102 +
                ", dkc103=" + dkc103 +
                ", dkc107=" + dkc107 +
                ", dkc204='" + dkc204 + '\'' +
                ", dkc201='" + dkc201 + '\'' +
                ", dka076='" + dka076 + '\'' +
                ", dkc009='" + dkc009 + '\'' +
                ", dka013='" + dka013 + '\'' +
                ", aae011='" + aae011 + '\'' +
                ", dka032=" + dka032 +
                ", dka034=" + dka034 +
                ", dka071=" + dka071 +
                ", dka033=" + dka033 +
                ", dka036=" + dka036 +
                ", aac003='" + aac003 + '\'' +
                ", dka030='" + dka030 + '\'' +
                ", acc300='" + acc300 + '\'' +
                ", aab301='" + aab301 + '\'' +
                ", dkc104=" + dkc104 +
                ", message='" + message + '\'' +
                ", success='" + success + '\'' +
                ", dkc232='" + dkc232 + '\'' +
                ", dkc230='" + dkc230 + '\'' +
                ", dka023='" + dka023 + '\'' +
                ", aae008='" + aae008 + '\'' +
                ", dka224='" + dka224 + '\'' +
                '}';
    }

    public Dk10(String aac002) {
        this.aac002=aac002;
    }

    public Dk10(String aac002, String aac003) {
        this.aac002=aac002;
        this.aac003=aac003;
    }


    //生成集合
    public List<Dk10> listDk10() {

        List<Dk10> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            BiFunction<String, String, Dk10> function = Dk10::new;
            list.add(function.apply("610122**********" + i, "张" + ConvertMoney.convert(i)));
        }
        return list;
    }

    //生成数组
    public Dk10[] arrayDk10() {

        Dk10[] dk10s = new Dk10[]{};
        for (int i = 0; i < 100; i++) {
            BiFunction<String, String, Dk10> function = Dk10::new;
            dk10s[i] = function.apply("610122**********" + i, "张" + ConvertMoney.convert(i));
        }
        return dk10s;
    }

    public Dk10(String aac002, String dkc011, Date dkc010, String dkc012, Date dkc100, Date dkc101, Date dkc102, Double dkc103, Double dkc107, String dkc204, String dkc201, String dka076, String dkc009, String dka013, String aae011, Double dka032, Double dka034, Double dka071, Date dka033, Date dka036, String aac003, String dka030, String acc300, String aab301, Double dkc104, String message, String success, String dkc232, String dkc230, String dka023, String aae008, String dka224) {
        this.aac002 = aac002;
        this.dkc011 = dkc011;
        this.dkc010 = dkc010;
        this.dkc012 = dkc012;
        this.dkc100 = dkc100;
        this.dkc101 = dkc101;
        this.dkc102 = dkc102;
        this.dkc103 = dkc103;
        this.dkc107 = dkc107;
        this.dkc204 = dkc204;
        this.dkc201 = dkc201;
        this.dka076 = dka076;
        this.dkc009 = dkc009;
        this.dka013 = dka013;
        this.aae011 = aae011;
        this.dka032 = dka032;
        this.dka034 = dka034;
        this.dka071 = dka071;
        this.dka033 = dka033;
        this.dka036 = dka036;
        this.aac003 = aac003;
        this.dka030 = dka030;
        this.acc300 = acc300;
        this.aab301 = aab301;
        this.dkc104 = dkc104;
        this.message = message;
        this.success = success;
        this.dkc232 = dkc232;
        this.dkc230 = dkc230;
        this.dka023 = dka023;
        this.aae008 = aae008;
        this.dka224 = dka224;
    }

    @Override
    public int compareTo(Dk10 o) {
        return 0;
    }
}