<?xml version="1.0"?>
<globals>
     <#assign Collection=extractLetters(name)>//从输入的title中获取输入字符
      <#assign collection_name=Collection?lower_case>//获取到的字符转成小写
      <#include "../common/common_globals.xml.ftl" />
      <global id="activity_layout" value="${Collection?lower_case}" />//作为activity的layout的命名
      <global id="ActivityName" value="${Collection}Activity" />//作为activity类名
      <global id="PresenterName" value="${Collection}Presenter" />//作为presenter类名
      <global id="IViewName" value="I${Collection}View" />//作为view接口名
      <global id="IPresenterName" value="I${Collection}Presenter" />//作为presenter接口名
      <global id="IContractName" value="I${Collection}Contract" />//作为Contract接口名

      <global id="excludeMenu" type="boolean" value="true" />
      <global id="generateActivityTitle" type="boolean" value="false" />

</globals>
