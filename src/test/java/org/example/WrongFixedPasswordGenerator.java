package org.example;

public class WrongFixedPasswordGenerator implements PasswwordGenerator{
    @Override
    public String generatePassword(){
        return "aabbccd"; //7글자
    }
}
