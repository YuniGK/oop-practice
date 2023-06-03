package org.example;

//램덤 패스워드를 제어하기 위한 인터페이스를 상속받음
public class User implements PasswwordGenerator{
    private String password;

    /* 패스워드 초기화 */
    public void initPassword(PasswwordGenerator passwwordGenerator){
        /* as-is */
        //RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
        //String randomPassword = randomPasswordGenerator.generatePassword();

        /* to-be */
        String password = passwwordGenerator.generatePassword();

        /* 비밀번호는 최소 8자 이상 12자 이하 */
        int length = password.length();

        if(length >= 8 && length <= 12){
            this.password = password;
        }
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String generatePassword() {
        return null;
    }
}
