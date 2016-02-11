/**
 * Created by devinpenny on 4/9/15.
 * the purpose of this class file is to create unique values for testing
 *
 */
// create a string of random characters, input the length of string to be created
exports.getRandomString = function (characterLength) {
    var randomText = "";
    var allowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    for (var i = 0; i < characterLength; i++)
        randomText += allowedCharacters.charAt(Math.floor(Math.random() * allowedCharacters.length));
    return randomText;
};
// create a string of random characters that are only Capitol letters or numbers, input the length of string to be created
exports.getRandomUpcaseString = function (characterLength) {
    var randomText = "";
    var allowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    for (var i = 0; i < characterLength; i++)
        randomText += allowedCharacters.charAt(Math.floor(Math.random() * allowedCharacters.length));
    return randomText;
};

// create a random number, input the length of the number to be created
exports.getRandomNumber = function (numberLength) {
    var randomNumber = "";
    var allowedNumbers = "0123456789";
    for (var i = 0; i < numberLength; i++)
        randomNumber += allowedNumbers.charAt(Math.floor(Math.random() * allowedNumbers.length));
    return randomNumber;
};

//Create a random email address
exports.getRandomEmail = function () {
    var strValues = "abcdef123456789.";
    var strEmail = "";
    for (var i = 0; i < strValues.length; i++) {
        strEmail = strEmail + strValues.charAt(Math.round(strValues.length * Math.random()));
    }
    return strEmail + "@ge.com";
};

exports.getSystemDateTime = function () {
    //var timeStamp = (new Date()).toString().split(' ').splice(1, 3).join(' ');

    var m_names = new Array('January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December');
    var d = new Date();
    var curr_date = d.getDate();
    var curr_month = d.getMonth();
    var curr_year = d.getFullYear();
    var timeStamp = ( m_names[curr_month] + " " + curr_date + ", " + curr_year);
    return timeStamp;
};

exports.getBrowserInfo = function () {
    var capsPromise = browser.getCapabilities();
    capsPromise.then(function(caps) {
        var browserName = caps.caps_.browserName.toUpperCase();
        var browserVersion = caps.caps_.version;
        var browserInfo = browserName + "-" + browserVersion + "-";
        return browserInfo;
    });

};


