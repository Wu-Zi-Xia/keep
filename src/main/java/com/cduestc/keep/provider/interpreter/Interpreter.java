package com.cduestc.keep.provider.interpreter;

import com.cduestc.keep.dto.SportsDto;
import com.cduestc.keep.mapper.*;
import com.cduestc.keep.model.*;
import org.springframework.beans.factory.annotation.Autowired;

//解释器类，为了解释每一天的计划的内容
public class Interpreter {
public static SportsDto getSportsUrl(String context){
    PlayContext playContext=new PlayContext();
    playContext.setText(context);
    Sports sports=new Sports();
    SportsDto interpret = sports.interpret(playContext);
    return interpret;
}
}

//解释的计划表里面的sports字段
class PlayContext
{
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

//表达式类
abstract class Expression
{
    protected String sportsType;
    protected String sportsID;
    @Autowired
    BackSportsMapper backSportsMapper;
    @Autowired
    BellySportsMapper bellySportsMapper;
    @Autowired
    ChestSportsMapper chestSportsMapper;
    @Autowired
    ForearmSportsMapper forearmSportsMapper;
    @Autowired
    ShankSportsMapper shankSportsMapper;
    @Autowired
    ThighSportsMapper thighSportsMapper;
    @Autowired
    ArmSportsMapper armSportsMapper;
    //解释器
    public SportsDto interpret(PlayContext playContext)

    {
        SportsDto excute;
        if(playContext.getText().length()==0)
        {
            return null;
        }
        else
        {
            String sportsType=playContext.getText().substring(0,1).trim();//获取当前文本的前一个字母
            //System.out.println(playKey);
            //System.out.println(playContext.getText());
            playContext.setText(playContext.getText().substring(1));
            //System.out.println(playContext.getText());
            String sportsID=playContext.getText().substring(0,playContext.getText().indexOf(",")).trim();
            playContext.setText(playContext.getText().substring(playContext.getText().indexOf(",")+1));
            //System.out.println(playContext.getText());
            // System.out.println(playValue);
             excute= excute(sportsType, sportsID);
        }
        return excute;
    }

    public abstract SportsDto excute(String playKey,String playValue);
}

class Sports extends Expression{

    @Override
    public SportsDto excute(String sportsType, String sportsID) {
        SportsDto sportsDto = new SportsDto();
        switch (sportsType){
            case "A":
                ArmSports armSports = armSportsMapper.selectByPrimaryKey(Long.parseLong(sportsID));
                sportsDto.setArmSports(armSports);
                break;
            case "F":
                ForearmSports forearmSports = forearmSportsMapper.selectByPrimaryKey(Long.parseLong(sportsID));
                sportsDto.setForearmSports(forearmSports);
                break;
            case "C":
                ChestSports chestSports = chestSportsMapper.selectByPrimaryKey(Long.parseLong(sportsID));
                sportsDto.setChestSports(chestSports);
                break;
            case "B":
                BackSports backSports = backSportsMapper.selectByPrimaryKey(Long.parseLong(sportsID));
                sportsDto.setBackSports(backSports);
                break;
            case "E":
                BellySports bellySports = bellySportsMapper.selectByPrimaryKey(Long.parseLong(sportsID));
                sportsDto.setBellySports(bellySports);
                break;
            case "T":
                ThighSports thighSports = thighSportsMapper.selectByPrimaryKey(Long.parseLong(sportsID));
                sportsDto.setThighSports(thighSports);
                break;
            case "S":
                ShankSports shankSports = shankSportsMapper.selectByPrimaryKey(Long.parseLong(sportsID));
                sportsDto.setShankSports(shankSports);
                break;
        }
        return sportsDto;
    }
}