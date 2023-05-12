package com.example.hw1;


import com.example.hw1.dto.UserDto;
import com.example.hw1.dto.scoreDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

public class MemberServiceImpl implements MemberService {

    @Override
    public List<Integer> LottoNum(int maxCount){

        List<Integer> lotto = new ArrayList<>(maxCount);

        if (maxCount != 6) { // 작동?
            System.out.println("Please set maxCount as 6!");
            return null;
        }
        for (int i = 0; i < maxCount; i++) {
            Random random = new Random();
            int ranNum = random.nextInt(45);
            lotto.add(ranNum);
        }

        return lotto;
    }

    @Override
    public double SubjectAvg(List <scoreDto> scores) {
        String isKorean = "^[ㄱ-ㅎ가-힣]*$";

        int count = 0;
        int totalScore = 0;
        for (scoreDto score : scores){
            if (Pattern.matches(isKorean , score.getSubject())) { // if subject name is Korean
                count++;
                totalScore += score.getScore();
            }
        }

        double average = totalScore / count;
        return average;
    }

    @Override
    public UserDto userEmail(UserDto userDto) {
        HashMap<String, String> db = new HashMap<>();
        db.put(userDto.getName(), userDto.getEmail());
        return null;
    }


}
