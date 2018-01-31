package online.qsx.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import online.qsx.dto.City;
import online.qsx.dto.District;
import online.qsx.dto.Province;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//http://localhost:8080/select/pro
@Controller
@RequestMapping(value = "/select")
public class SelectRegionController {
    //省份数据List
    private static List<Province> provinceList = new ArrayList<>();

    //城市数据Map：key=provinceCode;value=cities
    private static Map<String, List<City>> cityMap = new HashMap<>();
    private List<City> city;

    //区数据Map：key=cityCode;value=districts
    private static Map<String, List<District>> districtMap = new HashMap<>();
    private List<District> district;
    static {
        //初始化省、市、区数据
        provinceList.add(new Province("hubei", "湖北省"));
        provinceList.add(new Province("jilin", "吉林省"));
        List<City> cities1 = new ArrayList<>();
        cities1.add(new City("wuhan", "武汉市"));
        cities1.add(new City("suizhou", "随州市"));
        cityMap.put("hubei", cities1);

        List<City> cities2 = new ArrayList<>();
        cities2.add(new City("changchun", "长春市"));
        cities2.add(new City("jilin", "吉林市"));
        cityMap.put("jilin", cities2);

        List<District> district1 = new ArrayList<>();
        district1.add(new District("hongshan", "洪山区"));
        district1.add(new District("jiangxia", "江夏区"));
        districtMap.put("wuhan", district1);

        List<District> district2 = new ArrayList<>();
        district2.add(new District("hongshan", "曾都区"));
        district2.add(new District("jiangxia", "广水区"));
        districtMap.put("suizhou", district2);

        List<District> district3 = new ArrayList<>();
        district3.add(new District("chaoyang", "朝阳区"));
        district3.add(new District("nanguan", "南关区"));
        districtMap.put("changchun", district3);

        List<District> district4 = new ArrayList<>();
        district4.add(new District("chaoyang", "船营区"));
        district4.add(new District("nanguan", "龙潭区"));
        districtMap.put("jilin", district4);
    }
    /**
     * TODO 选择省份
     */
    @RequestMapping(value = "pro",method = {RequestMethod.GET})
    public String selectProvince(Model model){
    	model.addAttribute(provinceList);
		return "select";
    	
    }

    /**
     * TODO 选择市
     */
    @GetMapping(value="/cityJson",produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String cityJson(String provinceId){
        JSONObject json = new JSONObject();
        city = cityMap.get(provinceId);
        json.put("city",city);
        return json.toString();

    }
    /**
     * TODO 选择区
     */
    @GetMapping(value="/districtJson",produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String districtJson(String cityId){
        System.out.println(cityId);
        JSONObject json = new JSONObject();
        district = districtMap.get(cityId);
        System.out.println(district);
        json.put("district",district);
        return json.toString();
    }
}