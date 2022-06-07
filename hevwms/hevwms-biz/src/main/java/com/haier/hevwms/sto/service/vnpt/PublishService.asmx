<?xml version="1.0" encoding="utf-8"?>
<wsdl:definitions xmlns:s="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/" xmlns:tns="http://tempuri.org/" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tm="http://microsoft.com/wsdl/mime/textMatching/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" targetNamespace="http://tempuri.org/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
  <wsdl:types>
    <s:schema elementFormDefault="qualified" targetNamespace="http://tempuri.org/">
      <s:element name="ImportAndPublishInv">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xmlInvData" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="serial" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="convert" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ImportAndPublishInvResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="ImportAndPublishInvResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ImportAndPublishAssignedNo">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xmlInvData" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="serial" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="convert" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ImportAndPublishAssignedNoResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="ImportAndPublishAssignedNoResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ImportInv">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="xmlInvData" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="convert" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ImportInvResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="ImportInvResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ImportInvByPattern">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xmlInvData" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="serial" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="convert" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ImportInvByPatternResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="ImportInvByPatternResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="deleteInvoiceByFkey">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="lstFkey" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="deleteInvoiceByFkeyResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="deleteInvoiceByFkeyResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetInvDataByFkey">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="fkey" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="userName" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="userPass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="accPass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetInvDataByFkeyResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetInvDataByFkeyResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="deleteInvoiceByID">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="lstID" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="deleteInvoiceByIDResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="deleteInvoiceByIDResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="publishInv">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="invIDs" type="tns:ArrayOfInt" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="serial" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfInt">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="int" type="s:int" />
        </s:sequence>
      </s:complexType>
      <s:element name="publishInvResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="publishInvResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="PublishInvFkey">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="lsFkey" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="serial" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="PublishInvFkeyResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="PublishInvFkeyResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="PublishInvByDate">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="FromDate" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ToDate" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="PublishInvByDateResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="PublishInvByDateResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="UpdateCus">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="XMLCusData" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pass" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="convert" nillable="true" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="UpdateCusResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="UpdateCusResult" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="setCusCert">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="certSerial" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="certString" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="cusCode" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pass" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="setCusCertResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="setCusCertResult" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ImportFromXml">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="userName" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="productXml" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ImportFromXmlResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="ImportFromXmlResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetCertInfo">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="userName" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetCertInfoResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetCertInfoResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="syncInfomation">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="req" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="syncInfomationResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="syncInfomationResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SignIn">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="userName" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pass" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SignInResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="SignInResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="resetPassword">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="oldPass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="newPass" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="resetPasswordResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="resetPasswordResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="AppClientSyncInfoSystem">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="req" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="AppClientSyncInfoSystemResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="AppClientSyncInfoSystemResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="getCurrentNo">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="serial" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="getCurrentNoResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="getCurrentNoResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="syncClientInv">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xmlInvData" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="convert" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="syncClientInvResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="syncClientInvResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="updateInvoice">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xmlInvData" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="updateInvoiceResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="updateInvoiceResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="syncDecision">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="Pass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xmlDecision" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="syncDecisionResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="syncDecisionResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="syncPublish">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="Pass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xmlPublish" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="syncPublishResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="syncPublishResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetPublishInv">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="comtaxCode" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetPublishInvResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetPublishInvResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="syncInvCancel">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="Pass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xmlInvCancel" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="syncInvCancelResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="syncInvCancelResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="getDateTimeServer">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="Pass" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="getDateTimeServerResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="getDateTimeServerResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="syncClientInvoiceCancel">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="Pass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xmlInvoiceCancel" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="syncClientInvoiceCancelResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="syncClientInvoiceCancelResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ConvertForVerify">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="Pass" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="Id" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ConvertForVerifyResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="ConvertForVerifyResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="sendEmail">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="sendEmailResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="sendEmailResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="syncCert">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="Pass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xmlCert" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="syncCertResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="syncCertResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="syncInvoicev2">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="comtaxCode" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="currentYear" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="lastSync" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="syncInvoicev2Response">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="syncInvoicev2Result" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="syncInvoice">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="comtaxCode" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="lastSync" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="syncInvoiceResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="syncInvoiceResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetSingleInvoice">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="comtaxcode" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="serial" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="notax" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="isReSync" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetSingleInvoiceResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetSingleInvoiceResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="PaymentForVerify">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="Pass" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="Id" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="payment" type="s:int" />
            <s:element minOccurs="0" maxOccurs="1" name="note" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="PaymentForVerifyResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="PaymentForVerifyResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="sendEmailAgain">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xmlInvData" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="sendEmailAgainResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="sendEmailAgainResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="getHashInvWithToken">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xmlInvData" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="serialCert" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="type" type="s:int" />
            <s:element minOccurs="0" maxOccurs="1" name="invToken" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="serial" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="convert" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="getHashInvWithTokenResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="getHashInvWithTokenResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="publishInvWithToken">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xmlInvData" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="serial" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="publishInvWithTokenResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="publishInvWithTokenResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="AdjustReplaceInvWithToken">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xmlInvData" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="type" type="s:int" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="serial" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="AdjustReplaceInvWithTokenResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="AdjustReplaceInvWithTokenResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="CancelInvoiceWithToken">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xmlData" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="CancelInvoiceWithTokenResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="CancelInvoiceWithTokenResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="rolBackWithToken">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="id" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="rolBackWithTokenResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="rolBackWithTokenResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="importCertWithToken">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="certStr" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="importCertWithTokenResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="importCertWithTokenResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="getStatusInv">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xmlFkeyInv" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="getStatusInvResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="getStatusInvResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="getHashInv">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="serialCert" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xmlFkeyInv" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="getHashInvResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="getHashInvResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetInvoiceByFkey">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="comtaxcode" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="serial" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="notax" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="fkey" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetInvoiceByFkeyResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetInvoiceByFkeyResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetInvoiceByFkeys">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="comtaxcode" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="fkeys" type="tns:ArrayOfString" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfString">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="string" nillable="true" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetInvoiceByFkeysResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetInvoiceByFkeysResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetInForPublishCom">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="usernameService" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="passwordService" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="Pattern" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="Serial" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="DateFrom" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="DateTo" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetInForPublishComResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetInForPublishComResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SendAgainEmailServ">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xmlDataInvoiceEmail" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="hdPattern" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="Serial" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SendAgainEmailServResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="SendAgainEmailServResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetDataInvHsm">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="serial" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="no" type="s:decimal" />
            <s:element minOccurs="1" maxOccurs="1" name="noNew" type="s:decimal" />
            <s:element minOccurs="0" maxOccurs="1" name="publishDate" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="arisingDate" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="serialO" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="noO" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="type" type="s:int" />
            <s:element minOccurs="0" maxOccurs="1" name="key" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="isUpdate" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetDataInvHsmResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetDataInvHsmResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ImportAndPublishInvSignService">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xmlInvData" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="type" type="s:int" />
            <s:element minOccurs="0" maxOccurs="1" name="invToken" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="serial" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="convert" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ImportAndPublishInvSignServiceResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="ImportAndPublishInvSignServiceResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetMCCQThueByInvTokens">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="invTokens" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetMCCQThueByInvTokensResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetMCCQThueByInvTokensResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetMCCQThueByFkeys">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="fkeys" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetMCCQThueByFkeysResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetMCCQThueByFkeysResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetMCCQThueByInvTokensNoXMLSign">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="invTokens" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetMCCQThueByInvTokensNoXMLSignResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetMCCQThueByInvTokensNoXMLSignResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetMCCQThueByFkeysNoXMLSign">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="fkeys" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetMCCQThueByFkeysNoXMLSignResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetMCCQThueByFkeysNoXMLSignResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SendInvToCQTByFkeys">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="fkeys" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SendInvToCQTByFkeysResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="SendInvToCQTByFkeysResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SendInvToCQTByInvTokens">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="invTokens" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SendInvToCQTByInvTokensResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="SendInvToCQTByInvTokensResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SendInvNoticeErrors">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xml" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="convert" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SendInvNoticeErrorsResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="SendInvNoticeErrorsResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetHashInvNoticeErrors">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xml" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="convert" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetHashInvNoticeErrorsResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetHashInvNoticeErrorsResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetHashInvNoticeErrorsWithSmartCA">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xml" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="serial" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="convert" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetHashInvNoticeErrorsWithSmartCAResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetHashInvNoticeErrorsWithSmartCAResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SendInvNoticeErrorsWithSmartCA">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xml" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SendInvNoticeErrorsWithSmartCAResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="SendInvNoticeErrorsWithSmartCAResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SendInvNoticeErrorsWidthToken">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xml" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SendInvNoticeErrorsWidthTokenResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="SendInvNoticeErrorsWidthTokenResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="HandleInvoiceErrors">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="mtd" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="HandleInvoiceErrorsResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="HandleInvoiceErrorsResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ReceivedInvoiceErrors">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="mtd" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ReceivedInvoiceErrorsResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="ReceivedInvoiceErrorsResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetHashInvSmartCA">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xmlInvData" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="serialCert" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="type" type="s:int" />
            <s:element minOccurs="0" maxOccurs="1" name="invToken" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="serial" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="convert" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetHashInvSmartCAResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetHashInvSmartCAResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="PublishInvSmartCA">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xmlInvData" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="serial" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="PublishInvSmartCAResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="PublishInvSmartCAResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="UpdateCertificate">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="certinfo" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="serialCert" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="certType" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="id" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="UpdateCertificateResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="UpdateCertificateResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="DeleteCertificate">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="id" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="DeleteCertificateResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="DeleteCertificateResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetCertificates">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="userName" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetCertificatesResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetCertificatesResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="RegisterPublish">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="xmlInvData" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="type" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="RegisterPublishResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="RegisterPublishResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ReceivedRegisterPublish">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="mtd" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ReceivedRegisterPublishResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="ReceivedRegisterPublishResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="RegisterPublishInvoice">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="Pattern" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="Type" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="Serial" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="Quantity" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="RegisterPublishInvoiceResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="RegisterPublishInvoiceResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="CancelPublishInvoice">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Account" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ACpass" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="Pattern" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="Serial" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="CancelPublishInvoiceResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="CancelPublishInvoiceResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetTransactionItems">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="status" type="s:int" />
            <s:element minOccurs="0" maxOccurs="1" name="mtdiep" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="message" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="fromDate" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="toDate" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="mltdiep" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pattern" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="serial" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="invNo" type="s:decimal" />
            <s:element minOccurs="1" maxOccurs="1" name="step" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="pageIndex" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="pageSize" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetTransactionItemsResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetTransactionItemsResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetTransactionDetail">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="mtd" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetTransactionDetailResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetTransactionDetailResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetStepDetail">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="stepId" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="mtd" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetStepDetailResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetStepDetailResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetResultsTransaction">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="Id" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="tranErr" type="s:boolean" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetResultsTransactionResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetResultsTransactionResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
    </s:schema>
  </wsdl:types>
  <wsdl:message name="ImportAndPublishInvSoapIn">
    <wsdl:part name="parameters" element="tns:ImportAndPublishInv" />
  </wsdl:message>
  <wsdl:message name="ImportAndPublishInvSoapOut">
    <wsdl:part name="parameters" element="tns:ImportAndPublishInvResponse" />
  </wsdl:message>
  <wsdl:message name="ImportAndPublishAssignedNoSoapIn">
    <wsdl:part name="parameters" element="tns:ImportAndPublishAssignedNo" />
  </wsdl:message>
  <wsdl:message name="ImportAndPublishAssignedNoSoapOut">
    <wsdl:part name="parameters" element="tns:ImportAndPublishAssignedNoResponse" />
  </wsdl:message>
  <wsdl:message name="ImportInvSoapIn">
    <wsdl:part name="parameters" element="tns:ImportInv" />
  </wsdl:message>
  <wsdl:message name="ImportInvSoapOut">
    <wsdl:part name="parameters" element="tns:ImportInvResponse" />
  </wsdl:message>
  <wsdl:message name="ImportInvByPatternSoapIn">
    <wsdl:part name="parameters" element="tns:ImportInvByPattern" />
  </wsdl:message>
  <wsdl:message name="ImportInvByPatternSoapOut">
    <wsdl:part name="parameters" element="tns:ImportInvByPatternResponse" />
  </wsdl:message>
  <wsdl:message name="deleteInvoiceByFkeySoapIn">
    <wsdl:part name="parameters" element="tns:deleteInvoiceByFkey" />
  </wsdl:message>
  <wsdl:message name="deleteInvoiceByFkeySoapOut">
    <wsdl:part name="parameters" element="tns:deleteInvoiceByFkeyResponse" />
  </wsdl:message>
  <wsdl:message name="GetInvDataByFkeySoapIn">
    <wsdl:part name="parameters" element="tns:GetInvDataByFkey" />
  </wsdl:message>
  <wsdl:message name="GetInvDataByFkeySoapOut">
    <wsdl:part name="parameters" element="tns:GetInvDataByFkeyResponse" />
  </wsdl:message>
  <wsdl:message name="deleteInvoiceByIDSoapIn">
    <wsdl:part name="parameters" element="tns:deleteInvoiceByID" />
  </wsdl:message>
  <wsdl:message name="deleteInvoiceByIDSoapOut">
    <wsdl:part name="parameters" element="tns:deleteInvoiceByIDResponse" />
  </wsdl:message>
  <wsdl:message name="publishInvSoapIn">
    <wsdl:part name="parameters" element="tns:publishInv" />
  </wsdl:message>
  <wsdl:message name="publishInvSoapOut">
    <wsdl:part name="parameters" element="tns:publishInvResponse" />
  </wsdl:message>
  <wsdl:message name="PublishInvFkeySoapIn">
    <wsdl:part name="parameters" element="tns:PublishInvFkey" />
  </wsdl:message>
  <wsdl:message name="PublishInvFkeySoapOut">
    <wsdl:part name="parameters" element="tns:PublishInvFkeyResponse" />
  </wsdl:message>
  <wsdl:message name="PublishInvByDateSoapIn">
    <wsdl:part name="parameters" element="tns:PublishInvByDate" />
  </wsdl:message>
  <wsdl:message name="PublishInvByDateSoapOut">
    <wsdl:part name="parameters" element="tns:PublishInvByDateResponse" />
  </wsdl:message>
  <wsdl:message name="UpdateCusSoapIn">
    <wsdl:part name="parameters" element="tns:UpdateCus" />
  </wsdl:message>
  <wsdl:message name="UpdateCusSoapOut">
    <wsdl:part name="parameters" element="tns:UpdateCusResponse" />
  </wsdl:message>
  <wsdl:message name="setCusCertSoapIn">
    <wsdl:part name="parameters" element="tns:setCusCert" />
  </wsdl:message>
  <wsdl:message name="setCusCertSoapOut">
    <wsdl:part name="parameters" element="tns:setCusCertResponse" />
  </wsdl:message>
  <wsdl:message name="ImportFromXmlSoapIn">
    <wsdl:part name="parameters" element="tns:ImportFromXml" />
  </wsdl:message>
  <wsdl:message name="ImportFromXmlSoapOut">
    <wsdl:part name="parameters" element="tns:ImportFromXmlResponse" />
  </wsdl:message>
  <wsdl:message name="GetCertInfoSoapIn">
    <wsdl:part name="parameters" element="tns:GetCertInfo" />
  </wsdl:message>
  <wsdl:message name="GetCertInfoSoapOut">
    <wsdl:part name="parameters" element="tns:GetCertInfoResponse" />
  </wsdl:message>
  <wsdl:message name="syncInfomationSoapIn">
    <wsdl:part name="parameters" element="tns:syncInfomation" />
  </wsdl:message>
  <wsdl:message name="syncInfomationSoapOut">
    <wsdl:part name="parameters" element="tns:syncInfomationResponse" />
  </wsdl:message>
  <wsdl:message name="SignInSoapIn">
    <wsdl:part name="parameters" element="tns:SignIn" />
  </wsdl:message>
  <wsdl:message name="SignInSoapOut">
    <wsdl:part name="parameters" element="tns:SignInResponse" />
  </wsdl:message>
  <wsdl:message name="resetPasswordSoapIn">
    <wsdl:part name="parameters" element="tns:resetPassword" />
  </wsdl:message>
  <wsdl:message name="resetPasswordSoapOut">
    <wsdl:part name="parameters" element="tns:resetPasswordResponse" />
  </wsdl:message>
  <wsdl:message name="AppClientSyncInfoSystemSoapIn">
    <wsdl:part name="parameters" element="tns:AppClientSyncInfoSystem" />
  </wsdl:message>
  <wsdl:message name="AppClientSyncInfoSystemSoapOut">
    <wsdl:part name="parameters" element="tns:AppClientSyncInfoSystemResponse" />
  </wsdl:message>
  <wsdl:message name="getCurrentNoSoapIn">
    <wsdl:part name="parameters" element="tns:getCurrentNo" />
  </wsdl:message>
  <wsdl:message name="getCurrentNoSoapOut">
    <wsdl:part name="parameters" element="tns:getCurrentNoResponse" />
  </wsdl:message>
  <wsdl:message name="syncClientInvSoapIn">
    <wsdl:part name="parameters" element="tns:syncClientInv" />
  </wsdl:message>
  <wsdl:message name="syncClientInvSoapOut">
    <wsdl:part name="parameters" element="tns:syncClientInvResponse" />
  </wsdl:message>
  <wsdl:message name="updateInvoiceSoapIn">
    <wsdl:part name="parameters" element="tns:updateInvoice" />
  </wsdl:message>
  <wsdl:message name="updateInvoiceSoapOut">
    <wsdl:part name="parameters" element="tns:updateInvoiceResponse" />
  </wsdl:message>
  <wsdl:message name="syncDecisionSoapIn">
    <wsdl:part name="parameters" element="tns:syncDecision" />
  </wsdl:message>
  <wsdl:message name="syncDecisionSoapOut">
    <wsdl:part name="parameters" element="tns:syncDecisionResponse" />
  </wsdl:message>
  <wsdl:message name="syncPublishSoapIn">
    <wsdl:part name="parameters" element="tns:syncPublish" />
  </wsdl:message>
  <wsdl:message name="syncPublishSoapOut">
    <wsdl:part name="parameters" element="tns:syncPublishResponse" />
  </wsdl:message>
  <wsdl:message name="GetPublishInvSoapIn">
    <wsdl:part name="parameters" element="tns:GetPublishInv" />
  </wsdl:message>
  <wsdl:message name="GetPublishInvSoapOut">
    <wsdl:part name="parameters" element="tns:GetPublishInvResponse" />
  </wsdl:message>
  <wsdl:message name="syncInvCancelSoapIn">
    <wsdl:part name="parameters" element="tns:syncInvCancel" />
  </wsdl:message>
  <wsdl:message name="syncInvCancelSoapOut">
    <wsdl:part name="parameters" element="tns:syncInvCancelResponse" />
  </wsdl:message>
  <wsdl:message name="getDateTimeServerSoapIn">
    <wsdl:part name="parameters" element="tns:getDateTimeServer" />
  </wsdl:message>
  <wsdl:message name="getDateTimeServerSoapOut">
    <wsdl:part name="parameters" element="tns:getDateTimeServerResponse" />
  </wsdl:message>
  <wsdl:message name="syncClientInvoiceCancelSoapIn">
    <wsdl:part name="parameters" element="tns:syncClientInvoiceCancel" />
  </wsdl:message>
  <wsdl:message name="syncClientInvoiceCancelSoapOut">
    <wsdl:part name="parameters" element="tns:syncClientInvoiceCancelResponse" />
  </wsdl:message>
  <wsdl:message name="ConvertForVerifySoapIn">
    <wsdl:part name="parameters" element="tns:ConvertForVerify" />
  </wsdl:message>
  <wsdl:message name="ConvertForVerifySoapOut">
    <wsdl:part name="parameters" element="tns:ConvertForVerifyResponse" />
  </wsdl:message>
  <wsdl:message name="sendEmailSoapIn">
    <wsdl:part name="parameters" element="tns:sendEmail" />
  </wsdl:message>
  <wsdl:message name="sendEmailSoapOut">
    <wsdl:part name="parameters" element="tns:sendEmailResponse" />
  </wsdl:message>
  <wsdl:message name="syncCertSoapIn">
    <wsdl:part name="parameters" element="tns:syncCert" />
  </wsdl:message>
  <wsdl:message name="syncCertSoapOut">
    <wsdl:part name="parameters" element="tns:syncCertResponse" />
  </wsdl:message>
  <wsdl:message name="syncInvoicev2SoapIn">
    <wsdl:part name="parameters" element="tns:syncInvoicev2" />
  </wsdl:message>
  <wsdl:message name="syncInvoicev2SoapOut">
    <wsdl:part name="parameters" element="tns:syncInvoicev2Response" />
  </wsdl:message>
  <wsdl:message name="syncInvoiceSoapIn">
    <wsdl:part name="parameters" element="tns:syncInvoice" />
  </wsdl:message>
  <wsdl:message name="syncInvoiceSoapOut">
    <wsdl:part name="parameters" element="tns:syncInvoiceResponse" />
  </wsdl:message>
  <wsdl:message name="GetSingleInvoiceSoapIn">
    <wsdl:part name="parameters" element="tns:GetSingleInvoice" />
  </wsdl:message>
  <wsdl:message name="GetSingleInvoiceSoapOut">
    <wsdl:part name="parameters" element="tns:GetSingleInvoiceResponse" />
  </wsdl:message>
  <wsdl:message name="PaymentForVerifySoapIn">
    <wsdl:part name="parameters" element="tns:PaymentForVerify" />
  </wsdl:message>
  <wsdl:message name="PaymentForVerifySoapOut">
    <wsdl:part name="parameters" element="tns:PaymentForVerifyResponse" />
  </wsdl:message>
  <wsdl:message name="sendEmailAgainSoapIn">
    <wsdl:part name="parameters" element="tns:sendEmailAgain" />
  </wsdl:message>
  <wsdl:message name="sendEmailAgainSoapOut">
    <wsdl:part name="parameters" element="tns:sendEmailAgainResponse" />
  </wsdl:message>
  <wsdl:message name="getHashInvWithTokenSoapIn">
    <wsdl:part name="parameters" element="tns:getHashInvWithToken" />
  </wsdl:message>
  <wsdl:message name="getHashInvWithTokenSoapOut">
    <wsdl:part name="parameters" element="tns:getHashInvWithTokenResponse" />
  </wsdl:message>
  <wsdl:message name="publishInvWithTokenSoapIn">
    <wsdl:part name="parameters" element="tns:publishInvWithToken" />
  </wsdl:message>
  <wsdl:message name="publishInvWithTokenSoapOut">
    <wsdl:part name="parameters" element="tns:publishInvWithTokenResponse" />
  </wsdl:message>
  <wsdl:message name="AdjustReplaceInvWithTokenSoapIn">
    <wsdl:part name="parameters" element="tns:AdjustReplaceInvWithToken" />
  </wsdl:message>
  <wsdl:message name="AdjustReplaceInvWithTokenSoapOut">
    <wsdl:part name="parameters" element="tns:AdjustReplaceInvWithTokenResponse" />
  </wsdl:message>
  <wsdl:message name="CancelInvoiceWithTokenSoapIn">
    <wsdl:part name="parameters" element="tns:CancelInvoiceWithToken" />
  </wsdl:message>
  <wsdl:message name="CancelInvoiceWithTokenSoapOut">
    <wsdl:part name="parameters" element="tns:CancelInvoiceWithTokenResponse" />
  </wsdl:message>
  <wsdl:message name="rolBackWithTokenSoapIn">
    <wsdl:part name="parameters" element="tns:rolBackWithToken" />
  </wsdl:message>
  <wsdl:message name="rolBackWithTokenSoapOut">
    <wsdl:part name="parameters" element="tns:rolBackWithTokenResponse" />
  </wsdl:message>
  <wsdl:message name="importCertWithTokenSoapIn">
    <wsdl:part name="parameters" element="tns:importCertWithToken" />
  </wsdl:message>
  <wsdl:message name="importCertWithTokenSoapOut">
    <wsdl:part name="parameters" element="tns:importCertWithTokenResponse" />
  </wsdl:message>
  <wsdl:message name="getStatusInvSoapIn">
    <wsdl:part name="parameters" element="tns:getStatusInv" />
  </wsdl:message>
  <wsdl:message name="getStatusInvSoapOut">
    <wsdl:part name="parameters" element="tns:getStatusInvResponse" />
  </wsdl:message>
  <wsdl:message name="getHashInvSoapIn">
    <wsdl:part name="parameters" element="tns:getHashInv" />
  </wsdl:message>
  <wsdl:message name="getHashInvSoapOut">
    <wsdl:part name="parameters" element="tns:getHashInvResponse" />
  </wsdl:message>
  <wsdl:message name="GetInvoiceByFkeySoapIn">
    <wsdl:part name="parameters" element="tns:GetInvoiceByFkey" />
  </wsdl:message>
  <wsdl:message name="GetInvoiceByFkeySoapOut">
    <wsdl:part name="parameters" element="tns:GetInvoiceByFkeyResponse" />
  </wsdl:message>
  <wsdl:message name="GetInvoiceByFkeysSoapIn">
    <wsdl:part name="parameters" element="tns:GetInvoiceByFkeys" />
  </wsdl:message>
  <wsdl:message name="GetInvoiceByFkeysSoapOut">
    <wsdl:part name="parameters" element="tns:GetInvoiceByFkeysResponse" />
  </wsdl:message>
  <wsdl:message name="GetInForPublishComSoapIn">
    <wsdl:part name="parameters" element="tns:GetInForPublishCom" />
  </wsdl:message>
  <wsdl:message name="GetInForPublishComSoapOut">
    <wsdl:part name="parameters" element="tns:GetInForPublishComResponse" />
  </wsdl:message>
  <wsdl:message name="SendAgainEmailServSoapIn">
    <wsdl:part name="parameters" element="tns:SendAgainEmailServ" />
  </wsdl:message>
  <wsdl:message name="SendAgainEmailServSoapOut">
    <wsdl:part name="parameters" element="tns:SendAgainEmailServResponse" />
  </wsdl:message>
  <wsdl:message name="GetDataInvHsmSoapIn">
    <wsdl:part name="parameters" element="tns:GetDataInvHsm" />
  </wsdl:message>
  <wsdl:message name="GetDataInvHsmSoapOut">
    <wsdl:part name="parameters" element="tns:GetDataInvHsmResponse" />
  </wsdl:message>
  <wsdl:message name="ImportAndPublishInvSignServiceSoapIn">
    <wsdl:part name="parameters" element="tns:ImportAndPublishInvSignService" />
  </wsdl:message>
  <wsdl:message name="ImportAndPublishInvSignServiceSoapOut">
    <wsdl:part name="parameters" element="tns:ImportAndPublishInvSignServiceResponse" />
  </wsdl:message>
  <wsdl:message name="GetMCCQThueByInvTokensSoapIn">
    <wsdl:part name="parameters" element="tns:GetMCCQThueByInvTokens" />
  </wsdl:message>
  <wsdl:message name="GetMCCQThueByInvTokensSoapOut">
    <wsdl:part name="parameters" element="tns:GetMCCQThueByInvTokensResponse" />
  </wsdl:message>
  <wsdl:message name="GetMCCQThueByFkeysSoapIn">
    <wsdl:part name="parameters" element="tns:GetMCCQThueByFkeys" />
  </wsdl:message>
  <wsdl:message name="GetMCCQThueByFkeysSoapOut">
    <wsdl:part name="parameters" element="tns:GetMCCQThueByFkeysResponse" />
  </wsdl:message>
  <wsdl:message name="GetMCCQThueByInvTokensNoXMLSignSoapIn">
    <wsdl:part name="parameters" element="tns:GetMCCQThueByInvTokensNoXMLSign" />
  </wsdl:message>
  <wsdl:message name="GetMCCQThueByInvTokensNoXMLSignSoapOut">
    <wsdl:part name="parameters" element="tns:GetMCCQThueByInvTokensNoXMLSignResponse" />
  </wsdl:message>
  <wsdl:message name="GetMCCQThueByFkeysNoXMLSignSoapIn">
    <wsdl:part name="parameters" element="tns:GetMCCQThueByFkeysNoXMLSign" />
  </wsdl:message>
  <wsdl:message name="GetMCCQThueByFkeysNoXMLSignSoapOut">
    <wsdl:part name="parameters" element="tns:GetMCCQThueByFkeysNoXMLSignResponse" />
  </wsdl:message>
  <wsdl:message name="SendInvToCQTByFkeysSoapIn">
    <wsdl:part name="parameters" element="tns:SendInvToCQTByFkeys" />
  </wsdl:message>
  <wsdl:message name="SendInvToCQTByFkeysSoapOut">
    <wsdl:part name="parameters" element="tns:SendInvToCQTByFkeysResponse" />
  </wsdl:message>
  <wsdl:message name="SendInvToCQTByInvTokensSoapIn">
    <wsdl:part name="parameters" element="tns:SendInvToCQTByInvTokens" />
  </wsdl:message>
  <wsdl:message name="SendInvToCQTByInvTokensSoapOut">
    <wsdl:part name="parameters" element="tns:SendInvToCQTByInvTokensResponse" />
  </wsdl:message>
  <wsdl:message name="SendInvNoticeErrorsSoapIn">
    <wsdl:part name="parameters" element="tns:SendInvNoticeErrors" />
  </wsdl:message>
  <wsdl:message name="SendInvNoticeErrorsSoapOut">
    <wsdl:part name="parameters" element="tns:SendInvNoticeErrorsResponse" />
  </wsdl:message>
  <wsdl:message name="GetHashInvNoticeErrorsSoapIn">
    <wsdl:part name="parameters" element="tns:GetHashInvNoticeErrors" />
  </wsdl:message>
  <wsdl:message name="GetHashInvNoticeErrorsSoapOut">
    <wsdl:part name="parameters" element="tns:GetHashInvNoticeErrorsResponse" />
  </wsdl:message>
  <wsdl:message name="GetHashInvNoticeErrorsWithSmartCASoapIn">
    <wsdl:part name="parameters" element="tns:GetHashInvNoticeErrorsWithSmartCA" />
  </wsdl:message>
  <wsdl:message name="GetHashInvNoticeErrorsWithSmartCASoapOut">
    <wsdl:part name="parameters" element="tns:GetHashInvNoticeErrorsWithSmartCAResponse" />
  </wsdl:message>
  <wsdl:message name="SendInvNoticeErrorsWithSmartCASoapIn">
    <wsdl:part name="parameters" element="tns:SendInvNoticeErrorsWithSmartCA" />
  </wsdl:message>
  <wsdl:message name="SendInvNoticeErrorsWithSmartCASoapOut">
    <wsdl:part name="parameters" element="tns:SendInvNoticeErrorsWithSmartCAResponse" />
  </wsdl:message>
  <wsdl:message name="SendInvNoticeErrorsWidthTokenSoapIn">
    <wsdl:part name="parameters" element="tns:SendInvNoticeErrorsWidthToken" />
  </wsdl:message>
  <wsdl:message name="SendInvNoticeErrorsWidthTokenSoapOut">
    <wsdl:part name="parameters" element="tns:SendInvNoticeErrorsWidthTokenResponse" />
  </wsdl:message>
  <wsdl:message name="HandleInvoiceErrorsSoapIn">
    <wsdl:part name="parameters" element="tns:HandleInvoiceErrors" />
  </wsdl:message>
  <wsdl:message name="HandleInvoiceErrorsSoapOut">
    <wsdl:part name="parameters" element="tns:HandleInvoiceErrorsResponse" />
  </wsdl:message>
  <wsdl:message name="ReceivedInvoiceErrorsSoapIn">
    <wsdl:part name="parameters" element="tns:ReceivedInvoiceErrors" />
  </wsdl:message>
  <wsdl:message name="ReceivedInvoiceErrorsSoapOut">
    <wsdl:part name="parameters" element="tns:ReceivedInvoiceErrorsResponse" />
  </wsdl:message>
  <wsdl:message name="GetHashInvSmartCASoapIn">
    <wsdl:part name="parameters" element="tns:GetHashInvSmartCA" />
  </wsdl:message>
  <wsdl:message name="GetHashInvSmartCASoapOut">
    <wsdl:part name="parameters" element="tns:GetHashInvSmartCAResponse" />
  </wsdl:message>
  <wsdl:message name="PublishInvSmartCASoapIn">
    <wsdl:part name="parameters" element="tns:PublishInvSmartCA" />
  </wsdl:message>
  <wsdl:message name="PublishInvSmartCASoapOut">
    <wsdl:part name="parameters" element="tns:PublishInvSmartCAResponse" />
  </wsdl:message>
  <wsdl:message name="UpdateCertificateSoapIn">
    <wsdl:part name="parameters" element="tns:UpdateCertificate" />
  </wsdl:message>
  <wsdl:message name="UpdateCertificateSoapOut">
    <wsdl:part name="parameters" element="tns:UpdateCertificateResponse" />
  </wsdl:message>
  <wsdl:message name="DeleteCertificateSoapIn">
    <wsdl:part name="parameters" element="tns:DeleteCertificate" />
  </wsdl:message>
  <wsdl:message name="DeleteCertificateSoapOut">
    <wsdl:part name="parameters" element="tns:DeleteCertificateResponse" />
  </wsdl:message>
  <wsdl:message name="GetCertificatesSoapIn">
    <wsdl:part name="parameters" element="tns:GetCertificates" />
  </wsdl:message>
  <wsdl:message name="GetCertificatesSoapOut">
    <wsdl:part name="parameters" element="tns:GetCertificatesResponse" />
  </wsdl:message>
  <wsdl:message name="RegisterPublishSoapIn">
    <wsdl:part name="parameters" element="tns:RegisterPublish" />
  </wsdl:message>
  <wsdl:message name="RegisterPublishSoapOut">
    <wsdl:part name="parameters" element="tns:RegisterPublishResponse" />
  </wsdl:message>
  <wsdl:message name="ReceivedRegisterPublishSoapIn">
    <wsdl:part name="parameters" element="tns:ReceivedRegisterPublish" />
  </wsdl:message>
  <wsdl:message name="ReceivedRegisterPublishSoapOut">
    <wsdl:part name="parameters" element="tns:ReceivedRegisterPublishResponse" />
  </wsdl:message>
  <wsdl:message name="RegisterPublishInvoiceSoapIn">
    <wsdl:part name="parameters" element="tns:RegisterPublishInvoice" />
  </wsdl:message>
  <wsdl:message name="RegisterPublishInvoiceSoapOut">
    <wsdl:part name="parameters" element="tns:RegisterPublishInvoiceResponse" />
  </wsdl:message>
  <wsdl:message name="CancelPublishInvoiceSoapIn">
    <wsdl:part name="parameters" element="tns:CancelPublishInvoice" />
  </wsdl:message>
  <wsdl:message name="CancelPublishInvoiceSoapOut">
    <wsdl:part name="parameters" element="tns:CancelPublishInvoiceResponse" />
  </wsdl:message>
  <wsdl:message name="GetTransactionItemsSoapIn">
    <wsdl:part name="parameters" element="tns:GetTransactionItems" />
  </wsdl:message>
  <wsdl:message name="GetTransactionItemsSoapOut">
    <wsdl:part name="parameters" element="tns:GetTransactionItemsResponse" />
  </wsdl:message>
  <wsdl:message name="GetTransactionDetailSoapIn">
    <wsdl:part name="parameters" element="tns:GetTransactionDetail" />
  </wsdl:message>
  <wsdl:message name="GetTransactionDetailSoapOut">
    <wsdl:part name="parameters" element="tns:GetTransactionDetailResponse" />
  </wsdl:message>
  <wsdl:message name="GetStepDetailSoapIn">
    <wsdl:part name="parameters" element="tns:GetStepDetail" />
  </wsdl:message>
  <wsdl:message name="GetStepDetailSoapOut">
    <wsdl:part name="parameters" element="tns:GetStepDetailResponse" />
  </wsdl:message>
  <wsdl:message name="GetResultsTransactionSoapIn">
    <wsdl:part name="parameters" element="tns:GetResultsTransaction" />
  </wsdl:message>
  <wsdl:message name="GetResultsTransactionSoapOut">
    <wsdl:part name="parameters" element="tns:GetResultsTransactionResponse" />
  </wsdl:message>
  <wsdl:portType name="PublishServiceSoap">
    <wsdl:operation name="ImportAndPublishInv">
      <wsdl:input message="tns:ImportAndPublishInvSoapIn" />
      <wsdl:output message="tns:ImportAndPublishInvSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="ImportAndPublishAssignedNo">
      <wsdl:input message="tns:ImportAndPublishAssignedNoSoapIn" />
      <wsdl:output message="tns:ImportAndPublishAssignedNoSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="ImportInv">
      <wsdl:input message="tns:ImportInvSoapIn" />
      <wsdl:output message="tns:ImportInvSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="ImportInvByPattern">
      <wsdl:input message="tns:ImportInvByPatternSoapIn" />
      <wsdl:output message="tns:ImportInvByPatternSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="deleteInvoiceByFkey">
      <wsdl:input message="tns:deleteInvoiceByFkeySoapIn" />
      <wsdl:output message="tns:deleteInvoiceByFkeySoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetInvDataByFkey">
      <wsdl:input message="tns:GetInvDataByFkeySoapIn" />
      <wsdl:output message="tns:GetInvDataByFkeySoapOut" />
    </wsdl:operation>
    <wsdl:operation name="deleteInvoiceByID">
      <wsdl:input message="tns:deleteInvoiceByIDSoapIn" />
      <wsdl:output message="tns:deleteInvoiceByIDSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="publishInv">
      <wsdl:input message="tns:publishInvSoapIn" />
      <wsdl:output message="tns:publishInvSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="PublishInvFkey">
      <wsdl:input message="tns:PublishInvFkeySoapIn" />
      <wsdl:output message="tns:PublishInvFkeySoapOut" />
    </wsdl:operation>
    <wsdl:operation name="PublishInvByDate">
      <wsdl:input message="tns:PublishInvByDateSoapIn" />
      <wsdl:output message="tns:PublishInvByDateSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="UpdateCus">
      <wsdl:input message="tns:UpdateCusSoapIn" />
      <wsdl:output message="tns:UpdateCusSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="setCusCert">
      <wsdl:input message="tns:setCusCertSoapIn" />
      <wsdl:output message="tns:setCusCertSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="ImportFromXml">
      <wsdl:input message="tns:ImportFromXmlSoapIn" />
      <wsdl:output message="tns:ImportFromXmlSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetCertInfo">
      <wsdl:input message="tns:GetCertInfoSoapIn" />
      <wsdl:output message="tns:GetCertInfoSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="syncInfomation">
      <wsdl:input message="tns:syncInfomationSoapIn" />
      <wsdl:output message="tns:syncInfomationSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="SignIn">
      <wsdl:input message="tns:SignInSoapIn" />
      <wsdl:output message="tns:SignInSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="resetPassword">
      <wsdl:input message="tns:resetPasswordSoapIn" />
      <wsdl:output message="tns:resetPasswordSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="AppClientSyncInfoSystem">
      <wsdl:input message="tns:AppClientSyncInfoSystemSoapIn" />
      <wsdl:output message="tns:AppClientSyncInfoSystemSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="getCurrentNo">
      <wsdl:input message="tns:getCurrentNoSoapIn" />
      <wsdl:output message="tns:getCurrentNoSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="syncClientInv">
      <wsdl:input message="tns:syncClientInvSoapIn" />
      <wsdl:output message="tns:syncClientInvSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="updateInvoice">
      <wsdl:input message="tns:updateInvoiceSoapIn" />
      <wsdl:output message="tns:updateInvoiceSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="syncDecision">
      <wsdl:input message="tns:syncDecisionSoapIn" />
      <wsdl:output message="tns:syncDecisionSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="syncPublish">
      <wsdl:input message="tns:syncPublishSoapIn" />
      <wsdl:output message="tns:syncPublishSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetPublishInv">
      <wsdl:input message="tns:GetPublishInvSoapIn" />
      <wsdl:output message="tns:GetPublishInvSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="syncInvCancel">
      <wsdl:input message="tns:syncInvCancelSoapIn" />
      <wsdl:output message="tns:syncInvCancelSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="getDateTimeServer">
      <wsdl:input message="tns:getDateTimeServerSoapIn" />
      <wsdl:output message="tns:getDateTimeServerSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="syncClientInvoiceCancel">
      <wsdl:input message="tns:syncClientInvoiceCancelSoapIn" />
      <wsdl:output message="tns:syncClientInvoiceCancelSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="ConvertForVerify">
      <wsdl:input message="tns:ConvertForVerifySoapIn" />
      <wsdl:output message="tns:ConvertForVerifySoapOut" />
    </wsdl:operation>
    <wsdl:operation name="sendEmail">
      <wsdl:input message="tns:sendEmailSoapIn" />
      <wsdl:output message="tns:sendEmailSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="syncCert">
      <wsdl:input message="tns:syncCertSoapIn" />
      <wsdl:output message="tns:syncCertSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="syncInvoicev2">
      <wsdl:input message="tns:syncInvoicev2SoapIn" />
      <wsdl:output message="tns:syncInvoicev2SoapOut" />
    </wsdl:operation>
    <wsdl:operation name="syncInvoice">
      <wsdl:input message="tns:syncInvoiceSoapIn" />
      <wsdl:output message="tns:syncInvoiceSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetSingleInvoice">
      <wsdl:input message="tns:GetSingleInvoiceSoapIn" />
      <wsdl:output message="tns:GetSingleInvoiceSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="PaymentForVerify">
      <wsdl:input message="tns:PaymentForVerifySoapIn" />
      <wsdl:output message="tns:PaymentForVerifySoapOut" />
    </wsdl:operation>
    <wsdl:operation name="sendEmailAgain">
      <wsdl:input message="tns:sendEmailAgainSoapIn" />
      <wsdl:output message="tns:sendEmailAgainSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="getHashInvWithToken">
      <wsdl:input message="tns:getHashInvWithTokenSoapIn" />
      <wsdl:output message="tns:getHashInvWithTokenSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="publishInvWithToken">
      <wsdl:input message="tns:publishInvWithTokenSoapIn" />
      <wsdl:output message="tns:publishInvWithTokenSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="AdjustReplaceInvWithToken">
      <wsdl:input message="tns:AdjustReplaceInvWithTokenSoapIn" />
      <wsdl:output message="tns:AdjustReplaceInvWithTokenSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="CancelInvoiceWithToken">
      <wsdl:input message="tns:CancelInvoiceWithTokenSoapIn" />
      <wsdl:output message="tns:CancelInvoiceWithTokenSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="rolBackWithToken">
      <wsdl:input message="tns:rolBackWithTokenSoapIn" />
      <wsdl:output message="tns:rolBackWithTokenSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="importCertWithToken">
      <wsdl:input message="tns:importCertWithTokenSoapIn" />
      <wsdl:output message="tns:importCertWithTokenSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="getStatusInv">
      <wsdl:input message="tns:getStatusInvSoapIn" />
      <wsdl:output message="tns:getStatusInvSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="getHashInv">
      <wsdl:input message="tns:getHashInvSoapIn" />
      <wsdl:output message="tns:getHashInvSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetInvoiceByFkey">
      <wsdl:input message="tns:GetInvoiceByFkeySoapIn" />
      <wsdl:output message="tns:GetInvoiceByFkeySoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetInvoiceByFkeys">
      <wsdl:input message="tns:GetInvoiceByFkeysSoapIn" />
      <wsdl:output message="tns:GetInvoiceByFkeysSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetInForPublishCom">
      <wsdl:input message="tns:GetInForPublishComSoapIn" />
      <wsdl:output message="tns:GetInForPublishComSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="SendAgainEmailServ">
      <wsdl:input message="tns:SendAgainEmailServSoapIn" />
      <wsdl:output message="tns:SendAgainEmailServSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetDataInvHsm">
      <wsdl:input message="tns:GetDataInvHsmSoapIn" />
      <wsdl:output message="tns:GetDataInvHsmSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="ImportAndPublishInvSignService">
      <wsdl:input message="tns:ImportAndPublishInvSignServiceSoapIn" />
      <wsdl:output message="tns:ImportAndPublishInvSignServiceSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetMCCQThueByInvTokens">
      <wsdl:input message="tns:GetMCCQThueByInvTokensSoapIn" />
      <wsdl:output message="tns:GetMCCQThueByInvTokensSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetMCCQThueByFkeys">
      <wsdl:input message="tns:GetMCCQThueByFkeysSoapIn" />
      <wsdl:output message="tns:GetMCCQThueByFkeysSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetMCCQThueByInvTokensNoXMLSign">
      <wsdl:input message="tns:GetMCCQThueByInvTokensNoXMLSignSoapIn" />
      <wsdl:output message="tns:GetMCCQThueByInvTokensNoXMLSignSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetMCCQThueByFkeysNoXMLSign">
      <wsdl:input message="tns:GetMCCQThueByFkeysNoXMLSignSoapIn" />
      <wsdl:output message="tns:GetMCCQThueByFkeysNoXMLSignSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="SendInvToCQTByFkeys">
      <wsdl:input message="tns:SendInvToCQTByFkeysSoapIn" />
      <wsdl:output message="tns:SendInvToCQTByFkeysSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="SendInvToCQTByInvTokens">
      <wsdl:input message="tns:SendInvToCQTByInvTokensSoapIn" />
      <wsdl:output message="tns:SendInvToCQTByInvTokensSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="SendInvNoticeErrors">
      <wsdl:input message="tns:SendInvNoticeErrorsSoapIn" />
      <wsdl:output message="tns:SendInvNoticeErrorsSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetHashInvNoticeErrors">
      <wsdl:input message="tns:GetHashInvNoticeErrorsSoapIn" />
      <wsdl:output message="tns:GetHashInvNoticeErrorsSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetHashInvNoticeErrorsWithSmartCA">
      <wsdl:input message="tns:GetHashInvNoticeErrorsWithSmartCASoapIn" />
      <wsdl:output message="tns:GetHashInvNoticeErrorsWithSmartCASoapOut" />
    </wsdl:operation>
    <wsdl:operation name="SendInvNoticeErrorsWithSmartCA">
      <wsdl:input message="tns:SendInvNoticeErrorsWithSmartCASoapIn" />
      <wsdl:output message="tns:SendInvNoticeErrorsWithSmartCASoapOut" />
    </wsdl:operation>
    <wsdl:operation name="SendInvNoticeErrorsWidthToken">
      <wsdl:input message="tns:SendInvNoticeErrorsWidthTokenSoapIn" />
      <wsdl:output message="tns:SendInvNoticeErrorsWidthTokenSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="HandleInvoiceErrors">
      <wsdl:input message="tns:HandleInvoiceErrorsSoapIn" />
      <wsdl:output message="tns:HandleInvoiceErrorsSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="ReceivedInvoiceErrors">
      <wsdl:input message="tns:ReceivedInvoiceErrorsSoapIn" />
      <wsdl:output message="tns:ReceivedInvoiceErrorsSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetHashInvSmartCA">
      <wsdl:input message="tns:GetHashInvSmartCASoapIn" />
      <wsdl:output message="tns:GetHashInvSmartCASoapOut" />
    </wsdl:operation>
    <wsdl:operation name="PublishInvSmartCA">
      <wsdl:input message="tns:PublishInvSmartCASoapIn" />
      <wsdl:output message="tns:PublishInvSmartCASoapOut" />
    </wsdl:operation>
    <wsdl:operation name="UpdateCertificate">
      <wsdl:input message="tns:UpdateCertificateSoapIn" />
      <wsdl:output message="tns:UpdateCertificateSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="DeleteCertificate">
      <wsdl:input message="tns:DeleteCertificateSoapIn" />
      <wsdl:output message="tns:DeleteCertificateSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetCertificates">
      <wsdl:input message="tns:GetCertificatesSoapIn" />
      <wsdl:output message="tns:GetCertificatesSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="RegisterPublish">
      <wsdl:input message="tns:RegisterPublishSoapIn" />
      <wsdl:output message="tns:RegisterPublishSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="ReceivedRegisterPublish">
      <wsdl:input message="tns:ReceivedRegisterPublishSoapIn" />
      <wsdl:output message="tns:ReceivedRegisterPublishSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="RegisterPublishInvoice">
      <wsdl:input message="tns:RegisterPublishInvoiceSoapIn" />
      <wsdl:output message="tns:RegisterPublishInvoiceSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="CancelPublishInvoice">
      <wsdl:input message="tns:CancelPublishInvoiceSoapIn" />
      <wsdl:output message="tns:CancelPublishInvoiceSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetTransactionItems">
      <wsdl:input message="tns:GetTransactionItemsSoapIn" />
      <wsdl:output message="tns:GetTransactionItemsSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetTransactionDetail">
      <wsdl:input message="tns:GetTransactionDetailSoapIn" />
      <wsdl:output message="tns:GetTransactionDetailSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetStepDetail">
      <wsdl:input message="tns:GetStepDetailSoapIn" />
      <wsdl:output message="tns:GetStepDetailSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetResultsTransaction">
      <wsdl:input message="tns:GetResultsTransactionSoapIn" />
      <wsdl:output message="tns:GetResultsTransactionSoapOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:binding name="PublishServiceSoap" type="tns:PublishServiceSoap">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="ImportAndPublishInv">
      <soap:operation soapAction="http://tempuri.org/ImportAndPublishInv" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ImportAndPublishAssignedNo">
      <soap:operation soapAction="http://tempuri.org/ImportAndPublishAssignedNo" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ImportInv">
      <soap:operation soapAction="http://tempuri.org/ImportInv" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ImportInvByPattern">
      <soap:operation soapAction="http://tempuri.org/ImportInvByPattern" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="deleteInvoiceByFkey">
      <soap:operation soapAction="http://tempuri.org/deleteInvoiceByFkey" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetInvDataByFkey">
      <soap:operation soapAction="http://tempuri.org/GetInvDataByFkey" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="deleteInvoiceByID">
      <soap:operation soapAction="http://tempuri.org/deleteInvoiceByID" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="publishInv">
      <soap:operation soapAction="http://tempuri.org/publishInv" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="PublishInvFkey">
      <soap:operation soapAction="http://tempuri.org/PublishInvFkey" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="PublishInvByDate">
      <soap:operation soapAction="http://tempuri.org/PublishInvByDate" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="UpdateCus">
      <soap:operation soapAction="http://tempuri.org/UpdateCus" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="setCusCert">
      <soap:operation soapAction="http://tempuri.org/setCusCert" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ImportFromXml">
      <soap:operation soapAction="http://tempuri.org/ImportFromXml" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCertInfo">
      <soap:operation soapAction="http://tempuri.org/GetCertInfo" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="syncInfomation">
      <soap:operation soapAction="http://tempuri.org/syncInfomation" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SignIn">
      <soap:operation soapAction="http://tempuri.org/SignIn" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="resetPassword">
      <soap:operation soapAction="http://tempuri.org/resetPassword" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="AppClientSyncInfoSystem">
      <soap:operation soapAction="http://tempuri.org/AppClientSyncInfoSystem" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="getCurrentNo">
      <soap:operation soapAction="http://tempuri.org/getCurrentNo" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="syncClientInv">
      <soap:operation soapAction="http://tempuri.org/syncClientInv" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="updateInvoice">
      <soap:operation soapAction="http://tempuri.org/updateInvoice" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="syncDecision">
      <soap:operation soapAction="http://tempuri.org/syncDecision" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="syncPublish">
      <soap:operation soapAction="http://tempuri.org/syncPublish" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetPublishInv">
      <soap:operation soapAction="http://tempuri.org/GetPublishInv" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="syncInvCancel">
      <soap:operation soapAction="http://tempuri.org/syncInvCancel" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="getDateTimeServer">
      <soap:operation soapAction="http://tempuri.org/getDateTimeServer" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="syncClientInvoiceCancel">
      <soap:operation soapAction="http://tempuri.org/syncClientInvoiceCancel" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ConvertForVerify">
      <soap:operation soapAction="http://tempuri.org/ConvertForVerify" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="sendEmail">
      <soap:operation soapAction="http://tempuri.org/sendEmail" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="syncCert">
      <soap:operation soapAction="http://tempuri.org/syncCert" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="syncInvoicev2">
      <soap:operation soapAction="http://tempuri.org/syncInvoicev2" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="syncInvoice">
      <soap:operation soapAction="http://tempuri.org/syncInvoice" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetSingleInvoice">
      <soap:operation soapAction="http://tempuri.org/GetSingleInvoice" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="PaymentForVerify">
      <soap:operation soapAction="http://tempuri.org/PaymentForVerify" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="sendEmailAgain">
      <soap:operation soapAction="http://tempuri.org/sendEmailAgain" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="getHashInvWithToken">
      <soap:operation soapAction="http://tempuri.org/getHashInvWithToken" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="publishInvWithToken">
      <soap:operation soapAction="http://tempuri.org/publishInvWithToken" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="AdjustReplaceInvWithToken">
      <soap:operation soapAction="http://tempuri.org/AdjustReplaceInvWithToken" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="CancelInvoiceWithToken">
      <soap:operation soapAction="http://tempuri.org/CancelInvoiceWithToken" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="rolBackWithToken">
      <soap:operation soapAction="http://tempuri.org/rolBackWithToken" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="importCertWithToken">
      <soap:operation soapAction="http://tempuri.org/importCertWithToken" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="getStatusInv">
      <soap:operation soapAction="http://tempuri.org/getStatusInv" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="getHashInv">
      <soap:operation soapAction="http://tempuri.org/getHashInv" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetInvoiceByFkey">
      <soap:operation soapAction="http://tempuri.org/GetInvoiceByFkey" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetInvoiceByFkeys">
      <soap:operation soapAction="http://tempuri.org/GetInvoiceByFkeys" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetInForPublishCom">
      <soap:operation soapAction="http://tempuri.org/GetInForPublishCom" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SendAgainEmailServ">
      <soap:operation soapAction="http://tempuri.org/SendAgainEmailServ" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetDataInvHsm">
      <soap:operation soapAction="http://tempuri.org/GetDataInvHsm" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ImportAndPublishInvSignService">
      <soap:operation soapAction="http://tempuri.org/ImportAndPublishInvSignService" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMCCQThueByInvTokens">
      <soap:operation soapAction="http://tempuri.org/GetMCCQThueByInvTokens" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMCCQThueByFkeys">
      <soap:operation soapAction="http://tempuri.org/GetMCCQThueByFkeys" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMCCQThueByInvTokensNoXMLSign">
      <soap:operation soapAction="http://tempuri.org/GetMCCQThueByInvTokensNoXMLSign" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMCCQThueByFkeysNoXMLSign">
      <soap:operation soapAction="http://tempuri.org/GetMCCQThueByFkeysNoXMLSign" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SendInvToCQTByFkeys">
      <soap:operation soapAction="http://tempuri.org/SendInvToCQTByFkeys" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SendInvToCQTByInvTokens">
      <soap:operation soapAction="http://tempuri.org/SendInvToCQTByInvTokens" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SendInvNoticeErrors">
      <soap:operation soapAction="http://tempuri.org/SendInvNoticeErrors" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetHashInvNoticeErrors">
      <soap:operation soapAction="http://tempuri.org/GetHashInvNoticeErrors" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetHashInvNoticeErrorsWithSmartCA">
      <soap:operation soapAction="http://tempuri.org/GetHashInvNoticeErrorsWithSmartCA" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SendInvNoticeErrorsWithSmartCA">
      <soap:operation soapAction="http://tempuri.org/SendInvNoticeErrorsWithSmartCA" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SendInvNoticeErrorsWidthToken">
      <soap:operation soapAction="http://tempuri.org/SendInvNoticeErrorsWidthToken" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="HandleInvoiceErrors">
      <soap:operation soapAction="http://tempuri.org/HandleInvoiceErrors" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ReceivedInvoiceErrors">
      <soap:operation soapAction="http://tempuri.org/ReceivedInvoiceErrors" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetHashInvSmartCA">
      <soap:operation soapAction="http://tempuri.org/GetHashInvSmartCA" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="PublishInvSmartCA">
      <soap:operation soapAction="http://tempuri.org/PublishInvSmartCA" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="UpdateCertificate">
      <soap:operation soapAction="http://tempuri.org/UpdateCertificate" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="DeleteCertificate">
      <soap:operation soapAction="http://tempuri.org/DeleteCertificate" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCertificates">
      <soap:operation soapAction="http://tempuri.org/GetCertificates" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="RegisterPublish">
      <soap:operation soapAction="http://tempuri.org/RegisterPublish" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ReceivedRegisterPublish">
      <soap:operation soapAction="http://tempuri.org/ReceivedRegisterPublish" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="RegisterPublishInvoice">
      <soap:operation soapAction="http://tempuri.org/RegisterPublishInvoice" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="CancelPublishInvoice">
      <soap:operation soapAction="http://tempuri.org/CancelPublishInvoice" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetTransactionItems">
      <soap:operation soapAction="http://tempuri.org/GetTransactionItems" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetTransactionDetail">
      <soap:operation soapAction="http://tempuri.org/GetTransactionDetail" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetStepDetail">
      <soap:operation soapAction="http://tempuri.org/GetStepDetail" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetResultsTransaction">
      <soap:operation soapAction="http://tempuri.org/GetResultsTransaction" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="PublishServiceSoap12" type="tns:PublishServiceSoap">
    <soap12:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="ImportAndPublishInv">
      <soap12:operation soapAction="http://tempuri.org/ImportAndPublishInv" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ImportAndPublishAssignedNo">
      <soap12:operation soapAction="http://tempuri.org/ImportAndPublishAssignedNo" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ImportInv">
      <soap12:operation soapAction="http://tempuri.org/ImportInv" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ImportInvByPattern">
      <soap12:operation soapAction="http://tempuri.org/ImportInvByPattern" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="deleteInvoiceByFkey">
      <soap12:operation soapAction="http://tempuri.org/deleteInvoiceByFkey" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetInvDataByFkey">
      <soap12:operation soapAction="http://tempuri.org/GetInvDataByFkey" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="deleteInvoiceByID">
      <soap12:operation soapAction="http://tempuri.org/deleteInvoiceByID" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="publishInv">
      <soap12:operation soapAction="http://tempuri.org/publishInv" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="PublishInvFkey">
      <soap12:operation soapAction="http://tempuri.org/PublishInvFkey" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="PublishInvByDate">
      <soap12:operation soapAction="http://tempuri.org/PublishInvByDate" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="UpdateCus">
      <soap12:operation soapAction="http://tempuri.org/UpdateCus" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="setCusCert">
      <soap12:operation soapAction="http://tempuri.org/setCusCert" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ImportFromXml">
      <soap12:operation soapAction="http://tempuri.org/ImportFromXml" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCertInfo">
      <soap12:operation soapAction="http://tempuri.org/GetCertInfo" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="syncInfomation">
      <soap12:operation soapAction="http://tempuri.org/syncInfomation" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SignIn">
      <soap12:operation soapAction="http://tempuri.org/SignIn" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="resetPassword">
      <soap12:operation soapAction="http://tempuri.org/resetPassword" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="AppClientSyncInfoSystem">
      <soap12:operation soapAction="http://tempuri.org/AppClientSyncInfoSystem" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="getCurrentNo">
      <soap12:operation soapAction="http://tempuri.org/getCurrentNo" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="syncClientInv">
      <soap12:operation soapAction="http://tempuri.org/syncClientInv" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="updateInvoice">
      <soap12:operation soapAction="http://tempuri.org/updateInvoice" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="syncDecision">
      <soap12:operation soapAction="http://tempuri.org/syncDecision" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="syncPublish">
      <soap12:operation soapAction="http://tempuri.org/syncPublish" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetPublishInv">
      <soap12:operation soapAction="http://tempuri.org/GetPublishInv" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="syncInvCancel">
      <soap12:operation soapAction="http://tempuri.org/syncInvCancel" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="getDateTimeServer">
      <soap12:operation soapAction="http://tempuri.org/getDateTimeServer" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="syncClientInvoiceCancel">
      <soap12:operation soapAction="http://tempuri.org/syncClientInvoiceCancel" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ConvertForVerify">
      <soap12:operation soapAction="http://tempuri.org/ConvertForVerify" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="sendEmail">
      <soap12:operation soapAction="http://tempuri.org/sendEmail" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="syncCert">
      <soap12:operation soapAction="http://tempuri.org/syncCert" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="syncInvoicev2">
      <soap12:operation soapAction="http://tempuri.org/syncInvoicev2" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="syncInvoice">
      <soap12:operation soapAction="http://tempuri.org/syncInvoice" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetSingleInvoice">
      <soap12:operation soapAction="http://tempuri.org/GetSingleInvoice" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="PaymentForVerify">
      <soap12:operation soapAction="http://tempuri.org/PaymentForVerify" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="sendEmailAgain">
      <soap12:operation soapAction="http://tempuri.org/sendEmailAgain" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="getHashInvWithToken">
      <soap12:operation soapAction="http://tempuri.org/getHashInvWithToken" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="publishInvWithToken">
      <soap12:operation soapAction="http://tempuri.org/publishInvWithToken" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="AdjustReplaceInvWithToken">
      <soap12:operation soapAction="http://tempuri.org/AdjustReplaceInvWithToken" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="CancelInvoiceWithToken">
      <soap12:operation soapAction="http://tempuri.org/CancelInvoiceWithToken" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="rolBackWithToken">
      <soap12:operation soapAction="http://tempuri.org/rolBackWithToken" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="importCertWithToken">
      <soap12:operation soapAction="http://tempuri.org/importCertWithToken" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="getStatusInv">
      <soap12:operation soapAction="http://tempuri.org/getStatusInv" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="getHashInv">
      <soap12:operation soapAction="http://tempuri.org/getHashInv" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetInvoiceByFkey">
      <soap12:operation soapAction="http://tempuri.org/GetInvoiceByFkey" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetInvoiceByFkeys">
      <soap12:operation soapAction="http://tempuri.org/GetInvoiceByFkeys" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetInForPublishCom">
      <soap12:operation soapAction="http://tempuri.org/GetInForPublishCom" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SendAgainEmailServ">
      <soap12:operation soapAction="http://tempuri.org/SendAgainEmailServ" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetDataInvHsm">
      <soap12:operation soapAction="http://tempuri.org/GetDataInvHsm" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ImportAndPublishInvSignService">
      <soap12:operation soapAction="http://tempuri.org/ImportAndPublishInvSignService" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMCCQThueByInvTokens">
      <soap12:operation soapAction="http://tempuri.org/GetMCCQThueByInvTokens" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMCCQThueByFkeys">
      <soap12:operation soapAction="http://tempuri.org/GetMCCQThueByFkeys" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMCCQThueByInvTokensNoXMLSign">
      <soap12:operation soapAction="http://tempuri.org/GetMCCQThueByInvTokensNoXMLSign" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMCCQThueByFkeysNoXMLSign">
      <soap12:operation soapAction="http://tempuri.org/GetMCCQThueByFkeysNoXMLSign" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SendInvToCQTByFkeys">
      <soap12:operation soapAction="http://tempuri.org/SendInvToCQTByFkeys" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SendInvToCQTByInvTokens">
      <soap12:operation soapAction="http://tempuri.org/SendInvToCQTByInvTokens" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SendInvNoticeErrors">
      <soap12:operation soapAction="http://tempuri.org/SendInvNoticeErrors" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetHashInvNoticeErrors">
      <soap12:operation soapAction="http://tempuri.org/GetHashInvNoticeErrors" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetHashInvNoticeErrorsWithSmartCA">
      <soap12:operation soapAction="http://tempuri.org/GetHashInvNoticeErrorsWithSmartCA" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SendInvNoticeErrorsWithSmartCA">
      <soap12:operation soapAction="http://tempuri.org/SendInvNoticeErrorsWithSmartCA" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SendInvNoticeErrorsWidthToken">
      <soap12:operation soapAction="http://tempuri.org/SendInvNoticeErrorsWidthToken" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="HandleInvoiceErrors">
      <soap12:operation soapAction="http://tempuri.org/HandleInvoiceErrors" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ReceivedInvoiceErrors">
      <soap12:operation soapAction="http://tempuri.org/ReceivedInvoiceErrors" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetHashInvSmartCA">
      <soap12:operation soapAction="http://tempuri.org/GetHashInvSmartCA" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="PublishInvSmartCA">
      <soap12:operation soapAction="http://tempuri.org/PublishInvSmartCA" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="UpdateCertificate">
      <soap12:operation soapAction="http://tempuri.org/UpdateCertificate" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="DeleteCertificate">
      <soap12:operation soapAction="http://tempuri.org/DeleteCertificate" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCertificates">
      <soap12:operation soapAction="http://tempuri.org/GetCertificates" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="RegisterPublish">
      <soap12:operation soapAction="http://tempuri.org/RegisterPublish" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ReceivedRegisterPublish">
      <soap12:operation soapAction="http://tempuri.org/ReceivedRegisterPublish" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="RegisterPublishInvoice">
      <soap12:operation soapAction="http://tempuri.org/RegisterPublishInvoice" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="CancelPublishInvoice">
      <soap12:operation soapAction="http://tempuri.org/CancelPublishInvoice" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetTransactionItems">
      <soap12:operation soapAction="http://tempuri.org/GetTransactionItems" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetTransactionDetail">
      <soap12:operation soapAction="http://tempuri.org/GetTransactionDetail" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetStepDetail">
      <soap12:operation soapAction="http://tempuri.org/GetStepDetail" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetResultsTransaction">
      <soap12:operation soapAction="http://tempuri.org/GetResultsTransaction" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:service name="PublishService">
    <wsdl:port name="PublishServiceSoap" binding="tns:PublishServiceSoap">
      <soap:address location="https://aquavn-tt78admindemo.vnpt-invoice.com.vn/PublishService.asmx" />
    </wsdl:port>
    <wsdl:port name="PublishServiceSoap12" binding="tns:PublishServiceSoap12">
      <soap12:address location="https://aquavn-tt78admindemo.vnpt-invoice.com.vn/PublishService.asmx" />
    </wsdl:port>
  </wsdl:service>
</wsdl:definitions>