<?xml version="1.0"?>
<#import "root://activities/common/kotlin_macros.ftl" as kt>
<recipe>

    <merge from="root/AndroidManifest.xml.ftl"
             to="${escapeXmlAttribute(manifestOut)}/AndroidManifest.xml" />
 <instantiate from="root/res/layout/activity_layout.xml.ftl"
                   to="${escapeXmlAttribute(resOut)}/layout/activity_${activity_layout}.xml" />

    <instantiate from="root/src/app_package/MvpActivity.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${ActivityName}.java" />
    <instantiate from="root/src/app_package/MvpPresenter.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${PresenterName}.java" />
    <instantiate from="root/src/app_package/MvpIContract.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${IContractName}.java" />



</recipe>
