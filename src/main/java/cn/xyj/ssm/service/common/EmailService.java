package cn.xyj.ssm.service.common;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class EmailService {
    @Resource(name = "mailSender")
    private MailSender mailSender;

    @Resource(name = "simpleMailMessage")
    private SimpleMailMessage simpleMailMessage;

    /**
     * @方法名: sendMail
     * @参数名：@param subject  邮件主题
     * @参数名：@param content 邮件主题内容
     * @参数名：@param to         收件人Email地址
     * @描述语: 发送邮件
     */
    public void sendMail(String subject, String content, String to) {
        simpleMailMessage.setSubject(subject); //设置邮件主题
        simpleMailMessage.setText(content);  //设置邮件主题内容
        simpleMailMessage.setTo(to);             //设定收件人
        mailSender.send(simpleMailMessage); //发送邮件
    }

}

