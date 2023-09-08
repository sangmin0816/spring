package kr.co.teaspoon.test;

import kr.co.teaspoon.dto.Sample;

public class LombokTest {
    public static void main(String[] args) {
        Sample sampleDTO = new Sample();
        sampleDTO.setNo(1);
        sampleDTO.setName("kim1");
        System.out.println(sampleDTO.toString());
    }
}