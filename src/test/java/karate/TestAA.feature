Feature:
  Background:
    * def xmlResponse =
    """
      <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
<soap:Body>         <GetUserInfoResponse xmlns="http://example.com">             <UserId>123</UserId>             <UserName>John Doe</UserName>             <UserEmail>john@example.com</UserEmail>         </GetUserInfoResponse>     </soap:Body> </soap:Envelope>
    """
    Scenario:
    * def soapResponse = karate.xmlPath(xmlResponse)
    * def userInfo = {     userId: soapResponse['//GetUserInfoResponse/UserId'],
    userName: soapResponse['//GetUserInfoResponse/UserName'],     userEmail: soapResponse['//GetUserInfoResponse/UserEmail'] }
      * print userInfo * match userInfo == { userId: '123', userName: 'John Doe', userEmail: 'john@example.com' }

  public class UserInfo {
    private String userId;
    private String userName;
    private String userEmail;
    // Getters y setters
    // Constructor (puedes generar un constructor con tu IDE o manualmente)}