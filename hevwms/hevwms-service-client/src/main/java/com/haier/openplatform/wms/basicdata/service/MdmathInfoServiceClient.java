package com.haier.openplatform.wms.basicdata.service;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.BaseUser;

import java.util.List;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.MdMatInfoDTO;

public interface MdmathInfoServiceClient {
    
    /** 
    * @Title: searchMdmaInfo 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param pager
    * @param @param mdMathInfoDTO
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return Pager<MdMatInfoDTO>    返回类型 
    * @throws 
    */
    public Pager<MdMatInfoDTO> searchMdmaInfo(Pager<MdMatInfoDTO> pager,MdMatInfoDTO mdMathInfoDTO);

    /** 
    * @Title: createMdmatInfos 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param mdMathInfoDTO
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    public String createMdmatInfos(MdMatInfoDTO mdMathInfoDTO);
    
    
       /**
    * @Title: deleteMdmatInfo
    * @Description: 删除物料信息 (这里用一句话描述这个类的作用)
    * @param @param idList
    * @param @return
    * @return ExecuteResult<Boolean>
    * @throws
    */
    public  String deleteMdmatInfo(List<Long> idList);
    
    /**
    * @Title: updateMdmatInfo
    * @Description: 更新物料信息 (这里用一句话描述这个类的作用)
    * @param @param mdMathInfoDTO
    * @param @return
    * @return String
    * @throws
    */
    public  String updateMdmatInfo(MdMatInfoDTO mdMathInfoDTO);
       
    /** 
    * @Title: getMdMatInfoByParam 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param dto
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return List<MdMatInfoDTO>    返回类型 
    * @throws 
    */
    public List<MdMatInfoDTO> getMdMatInfoByParam(MdMatInfoDTO dto);

    /** 
    * @Title: importMaterialInfo 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param obj
    * @param @param user
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    public  String importMaterialInfo(List<MdMatInfoDTO> obj, BaseUser user);
    
    /** 
    * @Title: downloadData 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param user
    * @param @param materialNo
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return InterfaceOutDTO    返回类型 
    * @throws 
    */
    public InterfaceOutDTO downloadData(BaseUser user, String materialNo);
}
