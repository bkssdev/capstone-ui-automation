# capstone-ui-automation

This is a selenium based test automation project, which automates the testing of the CRUD operations of the capstone user interface.

It uses standard best practices for test automation, and contains the basics to introduce the trainees to key test automation concepts.

The pre-requisite for for running the test automation code is as follows:
1. The test automation suite runs against the component under test on your laptop, which is the capstone frontend and backend apps. 
So, you need to ensure the Capstone UI/Frontend functionality works as expected with the backend up and running.

2. You need to download and setup the test automation code in the same folder as the frontend and backend app. 
i.e. C:\Workspace\ . 
The test automation could be setup anywhere, but I recommend extracting it in the Workspace folder, so all project folders are together.

3. After performing step 2 above your workspace should contain the following:
C:\Workspace\capstone-backend
C:\Workspace\capstone-frontend
C:\Workspace\capstone-backend

4. To run the `list client` and the `create client` test methods in intellij, open the following:
    `com.bkss.capstone.crud.ClientTest`

5. Then run methods `viewClientListTest()` and `createClientTest()`
Running the above test methods will open up a chrome browser and automatedly perform the user action of navigating the capstone UI
to `list all existing clients` and `create a new client`.

6. Trainees are tasked to implement the `Edit Client` and `Delete Client` test methods as part of their labs.