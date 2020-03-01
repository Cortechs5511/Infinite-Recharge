#import googleTest
import gspread
import key_responses
from oauth2client.service_account import ServiceAccountCredentials

teams = {
    "435": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "2059": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "2642": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "3229": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "3459": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "4291": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "4561": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "4816": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "4828": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "5160": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "5190": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "5511": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "5518": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "5607": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "5762": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "5919": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "6004": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "6240": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "6496": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "6500": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "6502": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "6565": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "6908": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "7265": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "7463": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "7671": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "7763": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "7890": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    "8090": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    }

for dictionary in key_responses.list_of_hashes:
    if dictionary["Name"] == "":
        pass
    else:
        qual = dictionary["Qual #"]
        team_num = str(dictionary["Team Number"])

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

        defense = dictionary["Did they play Defense?"]
        quality = dictionary["Defense Quality?"]

        #add defense related stuff down here later
        #filler

        #updating teams dictionary
        teams[team_num][0] += 1 #matches played

        autoPoints = 2*topPortAuto + bottomPortAuto
        if movedAuto == "Yes":
            autoPoints += 5
        teams[team_num][1] += autoPoints #auto points

        teams[team_num][2] += 2*bottomPortAuto + bottomPortTeleop #bottom port points

        teams[team_num][3] += (4*topPortAuto + 2*topPortTeleop + 3*innerPortTeleop + 6*innerPortAuto) #top port shot points

        if climbed == "Yes":
            climbPoints = 25
        elif climbed == "Parked":
            climbPoints = 5
        else:
            climbPoints = 0
        teams[team_num][4] += climbPoints #climb points

        teams[team_num][5] += (topPortAuto + topPortTeleop + innerPortAuto + innerPortTeleop + topMissed) #top shot
        teams[team_num][6] += (bottomPortAuto + bottomPortTeleop + bottomMissed)#bottom shot
        teams[team_num][7] += (topMissed) #top missed
        teams[team_num][8] += (bottomMissed) #bottom missed

        if defense == "Yes":
            teams[team_num][10] += 1
            teams[team_num][11] += quality

        if climbed == "Yes":
            teams[team_num][9] += 1

'''for team in teams:
    team_check = team
    topPointsAvg = teams[team_check][3] / int(teams[team_check][0])
    bottomPointsAvg = teams[team_check][2] / int(teams[team_check][0])
    autoPointsAvg = teams[team_check][1] / int(teams[team_check][0])
    climbPointsAvg = teams[team_check][4] / int(teams[team_check][0])
    totalPointsAvg = (topPointsAvg + bottomPointsAvg + climbPointsAvg)
    print(str(team_check) + " " + str(totalPointsAvg))'''
'''for team in teams:
    team_check = team
    climbAcc = teams[team_check][9] / int(teams[team_check][0]) * 100
    if climbAcc > 30:
        print(team_check + " " + str(climbAcc) + "%")'''

'''for team in teams:
    team_check = team
    if teams[team_check][10] != 0:
        ovQuality = teams[team_check][11] / teams[team_check][10]
    else:
        ovQuality = 0
    print(team_check + " " + str(ovQuality))'''

for team in teams:
    team_check = team
    if teams[team_check][5] != 0:
        topAcc = (teams[team_check][5] - teams[team_check][7]) / teams[team_check][5] * 100
    else:
        topAcc = "N/A"
    if teams[team_check][6] != 0:
        bottomAcc = (teams[team_check][6] - teams[team_check][8]) / teams[team_check][6] * 100
    else:
        bottomAcc = "N/A"
    if topAcc != "N/A":
        if topAcc >= 60:
            print(team + " topAcc: " + str(topAcc))
    if bottomAcc != "N/A":
        if int(bottomAcc) >= 60:
            print(team + " bottomAcc: " + str(bottomAcc))

print(" ")
print(" -- -- --")
print(" ")

while True:
    team_check = input("Team to get data on? ")
    print(" ")
    print(team_check)
    print("Matches Played: " + str(teams[team_check][0]))
    '''matches played, points [top, bottom, auto, climb, total], accuracy [top, bottom, climb]'''
    topPointsAvg = teams[team_check][3] / int(teams[team_check][0])
    bottomPointsAvg = teams[team_check][2] / int(teams[team_check][0])
    autoPointsAvg = teams[team_check][1] / int(teams[team_check][0])
    climbPointsAvg = teams[team_check][4] / int(teams[team_check][0])
    totalPointsAvg = (topPointsAvg + bottomPointsAvg + climbPointsAvg)
    print("Top Points Avg: " + str(topPointsAvg))
    print("Bottom Points Avg: " + str(bottomPointsAvg))
    print("Auto Points Avg: " + str(autoPointsAvg))
    print("Climb Points Avg: " + str(climbPointsAvg))
    print("Total Points Avg: " + str(totalPointsAvg))
    print(" ")
    topBallsShot = (teams[team_num][5] - teams[team_num][7]) / teams[team_num][0]
    bottomBallsShot = (teams[team_num][6] - teams[team_num][8]) / teams[team_num][0]
    print("Top Balls Shot " + str(topBallsShot))
    print("Bottom Balls Shot " + str(bottomBallsShot))
    if teams[team_check][5] != 0:
        topAcc = (teams[team_check][5] - teams[team_check][7]) / teams[team_check][5] * 100
    else:
        topAcc = "N/A"
    if teams[team_check][6] != 0:
        bottomAcc = (teams[team_check][6] - teams[team_check][8]) / teams[team_check][6] * 100
    else:
        bottomAcc = "N/A"
    print(" ")
    climbAcc = teams[team_check][9] / int(teams[team_check][0]) * 100
    print("Top Shot Accuracy " + str(topAcc) + "%")
    print("Bottom Shot Accuracy " + str(bottomAcc) + "%")
    print("Climb Accuracy " + str(climbAcc) + "%")
    print(" ")
    print(' ')
