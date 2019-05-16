$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("customer.feature");
formatter.feature({
  "line": 2,
  "name": "Register and login",
  "description": "",
  "id": "register-and-login",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@createCustomer"
    }
  ]
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Register and Login to application",
  "description": "",
  "id": "register-and-login;register-and-login-to-application",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "I open application",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I get Login page Url",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I click to here link",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I input to email textbox with data \"autorandom\"",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I click to Submit button at Register page",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I get UserID infor",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "I get Password infor",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I open login page again",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "I input to Username textbox",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I input to Password textbox",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I click to Login button at Login page",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "Verify Home page displayed with message \"Welcome To Manager\u0027s Page of Guru99 Bank\"",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "I open New Customer page",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "Input to New Customer form with data",
  "rows": [
    {
      "cells": [
        "Name",
        "Gender",
        "DateOfBirth",
        "Address",
        "City",
        "State",
        "Pin",
        "Phone",
        "EMail",
        "Password"
      ],
      "line": 19
    },
    {
      "cells": [
        "\u003cName\u003e",
        "m",
        "\u003cDateOfBirth\u003e",
        "\u003cAddress\u003e",
        "\u003cCity\u003e",
        "\u003cState\u003e",
        "\u003cPin\u003e",
        "\u003cPhone\u003e",
        "\u003cEMail\u003e",
        "\u003cPassword\u003e"
      ],
      "line": 20
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "I click to Submit button at New Customer page",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "Verify message displayed with data \"\u003cMessage\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "I verify all above infomation created success",
  "rows": [
    {
      "cells": [
        "Name",
        "Gender",
        "DateOfBirth",
        "Address",
        "City",
        "State",
        "Pin",
        "Phone",
        "EMail"
      ],
      "line": 24
    },
    {
      "cells": [
        "\u003cName\u003e",
        "male",
        "\u003cDateOfBirth\u003e",
        "\u003cAddress\u003e",
        "\u003cCity\u003e",
        "\u003cState\u003e",
        "\u003cPin\u003e",
        "\u003cPhone\u003e",
        "\u003cEMail\u003e"
      ],
      "line": 25
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "I get Customer ID at New Customer page",
  "keyword": "When "
});
formatter.examples({
  "line": 28,
  "name": "New Customer info",
  "description": "",
  "id": "register-and-login;register-and-login-to-application;new-customer-info",
  "rows": [
    {
      "cells": [
        "Name",
        "DateOfBirth",
        "Address",
        "City",
        "State",
        "Pin",
        "Phone",
        "EMail",
        "Password",
        "Message"
      ],
      "line": 29,
      "id": "register-and-login;register-and-login-to-application;new-customer-info;1"
    },
    {
      "cells": [
        "Automation",
        "1999_01_01",
        "123 Le Loi",
        "Ho Noi",
        "Chau Anh",
        "123456",
        "0908765543",
        "Autotest",
        "123321",
        "Customer Registered Successfully!!!"
      ],
      "line": 30,
      "id": "register-and-login;register-and-login-to-application;new-customer-info;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 30,
  "name": "Register and Login to application",
  "description": "",
  "id": "register-and-login;register-and-login-to-application;new-customer-info;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@createCustomer"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I open application",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I get Login page Url",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I click to here link",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I input to email textbox with data \"autorandom\"",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I click to Submit button at Register page",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I get UserID infor",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "I get Password infor",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I open login page again",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "I input to Username textbox",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I input to Password textbox",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I click to Login button at Login page",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "Verify Home page displayed with message \"Welcome To Manager\u0027s Page of Guru99 Bank\"",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "I open New Customer page",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "Input to New Customer form with data",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5,
    6,
    7,
    8
  ],
  "rows": [
    {
      "cells": [
        "Name",
        "Gender",
        "DateOfBirth",
        "Address",
        "City",
        "State",
        "Pin",
        "Phone",
        "EMail",
        "Password"
      ],
      "line": 19
    },
    {
      "cells": [
        "Automation",
        "m",
        "1999_01_01",
        "123 Le Loi",
        "Ho Noi",
        "Chau Anh",
        "123456",
        "0908765543",
        "Autotest",
        "123321"
      ],
      "line": 20
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "I click to Submit button at New Customer page",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "Verify message displayed with data \"Customer Registered Successfully!!!\"",
  "matchedColumns": [
    9
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "I verify all above infomation created success",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5,
    6,
    7
  ],
  "rows": [
    {
      "cells": [
        "Name",
        "Gender",
        "DateOfBirth",
        "Address",
        "City",
        "State",
        "Pin",
        "Phone",
        "EMail"
      ],
      "line": 24
    },
    {
      "cells": [
        "Automation",
        "male",
        "1999_01_01",
        "123 Le Loi",
        "Ho Noi",
        "Chau Anh",
        "123456",
        "0908765543",
        "Autotest"
      ],
      "line": 25
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "I get Customer ID at New Customer page",
  "keyword": "When "
});
formatter.match({
  "location": "RegisterAndLoginSteps.iOpenApplication()"
});
formatter.result({
  "duration": 11110608500,
  "status": "passed"
});
formatter.match({
  "location": "RegisterAndLoginSteps.iGetLoginPageUrl()"
});
formatter.result({
  "duration": 23468400,
  "status": "passed"
});
formatter.match({
  "location": "RegisterAndLoginSteps.iClickToHereLink()"
});
formatter.result({
  "duration": 1932226200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "autorandom",
      "offset": 36
    }
  ],
  "location": "RegisterAndLoginSteps.iInputToEmailTextboxWithData(String)"
});
formatter.result({
  "duration": 2255169400,
  "status": "passed"
});
formatter.match({
  "location": "RegisterAndLoginSteps.iClickToSubmitButtonAtRegisterPage()"
});
formatter.result({
  "duration": 121759900,
  "status": "passed"
});
formatter.match({
  "location": "RegisterAndLoginSteps.iGetUserIDInfor()"
});
formatter.result({
  "duration": 1559211700,
  "status": "passed"
});
formatter.match({
  "location": "RegisterAndLoginSteps.iGetPasswordInfor()"
});
formatter.result({
  "duration": 328200000,
  "status": "passed"
});
formatter.match({
  "location": "RegisterAndLoginSteps.iOpenLoginPageAgain()"
});
formatter.result({
  "duration": 1925769900,
  "status": "passed"
});
formatter.match({
  "location": "RegisterAndLoginSteps.iInputToUsernameTextbox()"
});
formatter.result({
  "duration": 80599100,
  "status": "passed"
});
formatter.match({
  "location": "RegisterAndLoginSteps.iInputToPasswordTextbox()"
});
formatter.result({
  "duration": 52449000,
  "status": "passed"
});
formatter.match({
  "location": "RegisterAndLoginSteps.iClickToLoginButtonAtLoginPage()"
});
formatter.result({
  "duration": 452324400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Welcome To Manager\u0027s Page of Guru99 Bank",
      "offset": 41
    }
  ],
  "location": "RegisterAndLoginSteps.verifyHomePageDisplayedWithMessage(String)"
});
formatter.result({
  "duration": 2128912100,
  "status": "passed"
});
formatter.match({
  "location": "RegisterAndLoginSteps.iOpenNewCustomerPage()"
});
formatter.result({
  "duration": 2437974100,
  "status": "passed"
});
formatter.match({
  "location": "RegisterAndLoginSteps.inputToNewCustomerFormWithData(DataTable)"
});
formatter.result({
  "duration": 1090551200,
  "status": "passed"
});
formatter.match({
  "location": "RegisterAndLoginSteps.iClickToSubmitButtonAtNewCustomerPage()"
});
formatter.result({
  "duration": 1765776300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Customer Registered Successfully!!!",
      "offset": 36
    }
  ],
  "location": "RegisterAndLoginSteps.verifyMessageDisplayedWithData(String)"
});
formatter.result({
  "duration": 367949800,
  "status": "passed"
});
formatter.match({
  "location": "RegisterAndLoginSteps.iVerifyAllAboveInfomationCreatedSuccess(DataTable)"
});
formatter.result({
  "duration": 38921900,
  "status": "passed"
});
formatter.match({
  "location": "RegisterAndLoginSteps.iGetCustomerIDAtNewCustomerPage()"
});
formatter.result({
  "duration": 32055100,
  "status": "passed"
});
});