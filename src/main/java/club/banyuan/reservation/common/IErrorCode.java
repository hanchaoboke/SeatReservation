package club.banyuan.reservation.common;

/**
 * @author HanChao
 * @date 2020-06-10 19:19
 * 描述信息：
 */
/**
 * 封装API的错误码
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
