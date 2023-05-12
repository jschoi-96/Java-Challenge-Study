package com.example.hw1;

import com.example.hw1.dto.UserDto;
import com.example.hw1.dto.scoreDto;

import java.util.List;

public interface MemberService {

    public List <Integer> LottoNum (int maxCount);

    public double SubjectAvg(List <scoreDto> scores);

    public UserDto userEmail(UserDto userDto);
}
