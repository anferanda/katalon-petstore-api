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

def userRequest = WS.sendRequest(findTestObject('api-test-positive/Put-pet-dinamis'))

//3. Define Request Body

def json = new JsonSlurper().parseText(userRequest.getResponseBodyContent())

//4. Assertion for Response

WS.verifyResponseStatusCode(userRequest, 200)

// Mengakses nilai ID masing-masing

GlobalVariable.petId = json.id.toString() //harus diconvert ke string, kalau ngga diconvert ngga akan bisa ambil number
GlobalVariable.categoryId = json.category.id
GlobalVariable.petName = json.name
GlobalVariable.tagsId = json.tags[0].id
GlobalVariable.tagsName = json.tags[0].name

println("Created petID ${GlobalVariable.petId}")
println("Pet Name: ${GlobalVariable.petName}")

//5. Assertion for Request

assert GlobalVariable.petId instanceof String
assert GlobalVariable.categoryId == 1
assert GlobalVariable.petName instanceof String
assert GlobalVariable.tagsId  == 10
assert GlobalVariable.tagsName instanceof String