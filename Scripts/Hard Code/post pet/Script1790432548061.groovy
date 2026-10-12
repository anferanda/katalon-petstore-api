import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import groovy.json.JsonSlurper

//1. Define Header

def contentType = 'application/json'

//2. Define Method

def userRequest = WS.sendRequest(findTestObject('api-test/Post-pet'))

//3. Define Request Body

def requestBody = userRequest.getResponseBodyContent()
def jsonBody = new JsonSlurper().parseText(requestBody)

def header =

{
	"Content-Type" contentType
}

//4. Assertion for Response

WS.verifyResponseStatusCode(userRequest, 200)
WS.verifyElementPropertyValue(userRequest, 'id', 101)
WS.verifyElementPropertyValue(userRequest, 'category.id', 1)
WS.verifyElementPropertyValue(userRequest, 'tags[0].id', 0)
WS.verifyElementPropertyValue(userRequest, 'name', "doggie")

// Mengakses nilai ID masing-masing

def mainId = jsonBody.id
def categoryId = jsonBody.category.id
def tagId = jsonBody.tags[0].id

//5. Assertion for Request

assert mainId == 101 //id harus 3 dengan tipe data integer/ number, selain integer/ number akan dianggap salah, ini statis
assert categoryId == 1
assert tagId == 0
assert jsonBody.name instanceof String //gabungan angka, operator, character
