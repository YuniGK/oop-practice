package org.example;

public class CorrectFixedPasswordGenerator implements PasswwordGenerator{
    @Override
    public String generatePassword(){
        return "aabbccdd"; //8글자
    }
}
