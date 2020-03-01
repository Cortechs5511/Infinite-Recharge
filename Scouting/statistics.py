#import googleTest
import gspread
import key_responses
from oauth2client.service_account import ServiceAccountCredentials

teams = {
    '''"####": [matches_played, autoPoints, bottomPoints, topPoints, climbPoints, topShot, bottomShot, topMissed, bottomMissed]'''
    "435": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "2059": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "2642": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "3229": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "3459": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "4291": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "4816": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "4828": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "5160": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "5190": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "5511": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "5518": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "5607": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "5762": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "5919": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "6004": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "6240": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "6496": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "6500": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "6502": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "6565": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "6908": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "7265": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "7463": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "7671": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "7763": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "7890": [0, 0, 0, 0, 0, 0, 0, 0, 0],
    "8090": [0, 0, 0, 0, 0, 0, 0, 0, 0]
    }

for dictionary in key_responses.list_of_hashes:
    if dictionary["Name"] == "":
        pass
    else:
        qual = dictionary["Qual #"]
        team_num = dictionary["Team Number"]

        #init = dictionary["Crossed Init Line?"] not needed
        topPortAuto = int(dictionary["Top Port Shots"])
        bottomPortAuto = int(dictionary["Bottom Port Shots"])
        innerPortAuto = int(dictionary["Inner Port Shots (auto)"])
        movedAuto = dictionary["Did they move?"]

        topPortTeleop = int(dictionary["Top Port Scored"])
        bottomPortTeleop = int(dictionary["Bottom Port Scored"])
        innerPortTeleop = int(dictionary["Inner ports scored(tele op)"])

        topMissed = int(dictionary["Top port missed"])
        bottomMissed = int(dictionary["Bottom port missed"])

        trench = dictionary["Ran the Trench?"]
        rotationC = dictionary["Rotation Control?"]
        positionC = dictionary["Position/Color Control?"]
        climbed = dictionary["Climbed?"]

        #add defense related stuff down here later
        #filler

        #updating teams dictionary
        teams[team_num][0] += 1 #matches played

        autoPoints = 2*topPortAuto + bottomPortAuto
        if movedAuto == "Yes":
            autoPoints += 5
        teams[team_num][1] += autoPoints #auto points

        teams[team_num][2] += 2*bottomPortAuto + bottomPortTeleop #bottom port points

        teams[team_num][3] += (4*topPortAuto + 2*topPortTeleop + 3*innerPortTeleop + 6*innerPortAuto) #top port shots

        if climbed == "Yes":
            climbPoints = 25
        elif climbed == "Parked":
            climbPoints = 5
        else:
            climbPoints = 0
        teams[team_num][4] += climbPoints #climb points

        teams[team_num][5] += (topPortAuto + topPortTeleop + innerPortAuto + innerPortTeleop) #top shot
        teams[team_num][5] += (bottomPortAuto + bottomPortTeleop)#bottom shot
        teams[team_num][5] += (topMissed) #top missed
        teams[team_num][5] += (bottomMissed) #bottom missed

team_check = input("Team to get data on? ")
print(" ")
print(team_check)
print("Matches Played: " + str(matches_played))
'''matches played, points [top, bottom, auto, climb, total], accuracy [top, bottom, climb]'''
