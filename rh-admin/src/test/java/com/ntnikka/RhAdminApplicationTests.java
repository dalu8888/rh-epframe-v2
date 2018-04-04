package com.ntnikka;

import com.github.crab2died.ExcelUtils;
import com.ntnikka.model.GbTempEntity;
import com.ntnikka.modules.apply.entity.GbEntity;
import com.ntnikka.modules.apply.service.GbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class RhAdminApplicationTests {

	@Autowired
	private GbService gbService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void excel2Object() throws Exception {

		String path = "C:\\home\\最新2017年国民经济行业分类(GB-T-4754—2017).xlsx";

		System.out.println("读取全部：");
		List<GbTempEntity> gbcodes = ExcelUtils.getInstance().readExcel2Objects(path, GbTempEntity.class);
		for (GbTempEntity gbtp : gbcodes) {
			GbEntity gb=new GbEntity();
			gb.setCid(gbtp.getCid());
			gb.setName(gbtp.getName());
			gb.setBid(gbtp.getBid());
			gb.setBname(gbtp.getBname());
			gb.setMid(gbtp.getMid());
			gb.setMname(gbtp.getMname());
			gb.setLid(gbtp.getLid());
			gb.setLname(gbtp.getLname());
			gbService.save(gb);
			System.out.println(gb.getBname());
		}
//		System.out.println("读取指定行数：");
//		gbcodes = ExcelUtils.getInstance().readExcel2Objects(path, GbTempEntity.class, 0, 3, 0);
//		for (GbTempEntity gb : gbcodes) {
//			System.out.println(gb);
//		}
	}

}
