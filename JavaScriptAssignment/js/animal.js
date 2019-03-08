/* Written by: Simonas Petkevicius
   Mole username: acc17sp
   date finished: 9/12/2018
*/

function spriteSheet (parameters) {

  // creating animation object
  var animation = new Object();

  // declaring variables in the animation object
  animation.context = parameters.context;
  animation.width = parameters.width;
  animation.height = parameters.height;
  animation.image = parameters.image;

  // variables that are used to make animation slower and not instantaneous
  var frameNumber = 0;
  var time = 0;
  var frameTimer = parameters.frameTimer;
  var numberOfFrames = parameters.numberOfFrames;
  var frameWidth = animation.width / numberOfFrames;

   // animation drawing function
  animation.draw = function () {

    // draws one spritesheet frame at a time
    animation.context.drawImage(
      animation.image,
      frameNumber * frameWidth,
      0,
      frameWidth,
      animation.height,
      100,
      100,
      frameWidth,
      animation.height); 
  };

  // function that changes the frame number which later used in draw() function to draw that frame
  animation.changeFrame = function () {

    time += 1;

    if(time > frameTimer) {

      time = 0;
      frameNumber += 1;
    }
  };

  /* restores the time and the frameNumber that it would draw from the beggining
   * everytime you begin new animation */
  animation.restoreFrames = function () {

    frameNumber = 0;
    time = 0;
  }

  // returns animation object that is equal to specific movement object
  return animation;
}

// draws stretching animation
function stretchAnimation() {

  // base case of the recursion requestAnimationFrame. Stops it after 25th recursion
  if (recursions >= 25) {

    cancelAnimationFrame(stopRecursion);
    stretchMovement.restoreFrames();
  }
  // recursive case of the requestAnimationFrame
  else {

    stopRecursion = requestAnimationFrame(stretchAnimation);
    stretchMovement.changeFrame();
    stretchMovement.draw();
    recursions += 1;
  }
}

// draws yawn animation
function yawnAnimation() {

  // base case of the recursion requestAnimationFrame. Stops it after 15th recursion
  if (recursions >= 15) {

    cancelAnimationFrame(stopRecursion);
    yawnMovement.restoreFrames();
  }
  // recursive case of the requestAnimationFrame
  else {

    stopRecursion = requestAnimationFrame(yawnAnimation);
    yawnMovement.changeFrame();
    yawnMovement.draw();
    recursions += 1;
  }
}

// draws sitting animation
function sittingAnimation() {

  // base case of the recursion requestAnimationFrame. Stops it after 30th recursion
  if (recursions >= 30) {

    cancelAnimationFrame(stopRecursion);
    sittingMovement.restoreFrames();
  }
  // recursive case of the requestAnimationFrame
  else {

    stopRecursion = requestAnimationFrame(sittingAnimation);
    sittingMovement.changeFrame();
    sittingMovement.draw();
    recursions += 1;
  }
}

// draws tail animation
function tailAnimation() {

  // base case of the recursion requestAnimationFrame. Stops it after 100th recursion
  if (recursions >= 100) {

    cancelAnimationFrame(stopRecursion);
    tailMovement.restoreFrames();
  }
  // recursive case of the requestAnimationFrame
  else {

    stopRecursion = requestAnimationFrame(tailAnimation);
    tailMovement.changeFrame();
    tailMovement.draw();
    recursions += 1;
  }
}

// draws laydown animation
function laydownAnimation() {

  // base case of the recursion requestAnimationFrame. Stops it after 25th recursion
  if(recursions >= 25) {

    cancelAnimationFrame(stopRecursion);
    laydownMovement.restoreFrames();
  }
  // recursive case of the requestAnimationFrame
  else {

    stopRecursion = requestAnimationFrame(laydownAnimation);
    laydownMovement.changeFrame();
    laydownMovement.draw();
    recursions += 1;
  }
}

// draws sleeping animation
function sleepingAnimation() {

  // base case of the recursion requestAnimationFrame. Stops it after 15th recursion
  if(recursions >= 15) {

    cancelAnimationFrame(stopRecursion);
    eyeMovement.restoreFrames();
    recursions = 0;
    stopSleeping = false;
    isSleeping = true;
    zzzAnimation();
  }
  // recursive case of the requestAnimationFrame
  else {

    stopRecursion = requestAnimationFrame(sleepingAnimation);
    eyeMovement.changeFrame();
    eyeMovement.draw();
    recursions += 1;
  }
}

// draws zZZ animation as well as wakes the animal up if there is a click on the canvas
function zzzAnimation() {

  // base case of the recursion requestAnimationFrame. Stops it after 25th recursion
  if(recursions >=25) {

    cancelAnimationFrame(stopZZZ);
    zzzMovement.restoreFrames();
    canvas.addEventListener('click', function (){ stopSleeping = true; }, true);
    recursions = 0;
    // if there was no click on the canvas restart the animation from th beggining
    if (!stopSleeping) {

      zzzAnimation();
    }
    else {

      loadInitialImage();
      isSleeping = false;
    }
  }
  // recursive case of the requestAnimationFrame
  else {

    stopZZZ = requestAnimationFrame(zzzAnimation);
    zzzMovement.changeFrame();
    zzzMovement.draw();
    recursions += 1;
  }
}

// Decides where was the click on a canvas and starts one of four animations if the click was in a certain rectangle
function onClickCanvas(evt){

  var mouseCoor = getMouseCoordinates(canvas, evt);

  if((mouseCoor.x > 175 && mouseCoor.x < 320) && (mouseCoor.y > 250 && mouseCoor.y < 300) && !isSleeping) {

    recursions = 0;
    laydownAnimation();
  }
  else if((mouseCoor.x > 140 && mouseCoor.x < 190) && (mouseCoor.y > 165 && mouseCoor.y < 180) && !isSleeping) {

    recursions = 0;
    laydownAnimation();
  }
  else if((mouseCoor.x > 140 && mouseCoor.x < 190) && (mouseCoor.y > 200 && mouseCoor.y < 208) && !isSleeping) {

    recursions = 0;
    sleepingAnimation();
  }
  else if((mouseCoor.x > 335 && mouseCoor.x < 390) && (mouseCoor.y > 170 && mouseCoor.y < 220) && !isSleeping) {

    recursions = 0;
    tailAnimation();
  }
}

// gets mouse coordinates from the canvas
function getMouseCoordinates(canvas, evt) {

  var boundries = canvas.getBoundingClientRect();
  var coordinateX = evt.clientX - boundries.left;
  var coordinateY = evt.clientY - boundries.top;

  return {
    x: coordinateX,
    y: coordinateY
  };
}

// loads the first image whenever page is started or the restart my life button is pressed
function loadInitialImage() {

  ctx.drawImage(
    initialImage,
    100,
    100,
  );
}

/* Main Program */

// variables for the recursion animation
var stopRecursion;
var recursions;
var stopZZZ

// get all the buttons for the animtion
var stretchingButton = document.getElementById("stretching");
var yawnButton = document.getElementById("yawn");
var sittingButton = document.getElementById("sitting");
var restartButton = document.getElementById("restart");

// get canvas set 2d context and set the canvas width and height to 500 px
var canvas = document.getElementById("myCanvas");
var ctx = canvas.getContext("2d");
canvas.width = 500;
canvas.height = 500;

// variables for helping with sleeping animation
var stopSleeping = false;
var isSleeping = false;

// creating image variable and specifing the source location of the images
var initialImage = new Image();
initialImage.src = "images/initial.png";

var sleepImage = new Image();
sleepImage.src = "images/sleep.png";

var zzzImage = new Image();
zzzImage.src = "images/zzz.png";

var flyingTailImage = new Image();
flyingTailImage.src = "images/flyingtail.png";

var laydownImage = new Image();
laydownImage.src = "images/laydown.png";

var sittingImage = new Image();
sittingImage.src = "images/sitting.png";

var stretchImage = new Image();
stretchImage.src = "images/stretch.png";

var yawnImage = new Image();
yawnImage.src = "images/yawn.png";

// loading the firt backgorund image and setting up background image restart button
initialImage.addEventListener("load", loadInitialImage);
restartButton.addEventListener("click",function() {
                                        cancelAnimationFrame(stopRecursion);
                                        cancelAnimationFrame(stopZZZ);
                                        isSleeping = false;
                                        loadInitialImage(); });

// Creating movement objects using spritesheet function and animation object in it
var eyeMovement = spriteSheet({
    context: ctx,
    width: 900,
    height: 250,
    image: sleepImage,
    numberOfFrames: 3,
    frameTimer: 5
});

var zzzMovement = spriteSheet({
    context: ctx,
    width: 1500,
    height: 250,
    image: zzzImage,
    numberOfFrames: 5,
    frameTimer: 5
});

var tailMovement = spriteSheet({
    context: ctx,
    width: 5100,
    height: 250,
    image: flyingTailImage,
    numberOfFrames: 17,
    frameTimer: 5
});

var laydownMovement = spriteSheet({
    context: ctx,
    width: 1500,
    height: 250,
    image: laydownImage,
    numberOfFrames: 5,
    frameTimer: 5
});

var sittingMovement = spriteSheet({
    context: ctx,
    width: 1800,
    height: 250,
    image: sittingImage,
    numberOfFrames: 6,
    frameTimer: 5
});

var stretchMovement = spriteSheet({
    context: ctx,
    width: 1500,
    height: 250,
    image: stretchImage,
    numberOfFrames: 5,
    frameTimer: 5
});

var yawnMovement = spriteSheet({
    context: ctx,
    width: 900,
    height: 250,
    image: yawnImage,
    numberOfFrames: 3,
    frameTimer: 5  
});

// creating animation buttons
stretchingButton.addEventListener("click",function() {

                                            recursions = 0;
                                            // If the animal is sleeping do not allow him to do animations
                                            if(!isSleeping) {
                                            // in case any animation is not yet stopped
                                            cancelAnimationFrame(stopRecursion);
                                            stretchAnimation();}});

yawnButton.addEventListener("click",function() {

                                      recursions = 0;
                                      if(!isSleeping) {
                                      cancelAnimationFrame(stopRecursion);
                                      yawnAnimation();}});

sittingButton.addEventListener("click",function() {
                                        recursions = 0;
                                        if(!isSleeping) {
                                        cancelAnimationFrame(stopRecursion);
                                        sittingAnimation();}});

canvas.addEventListener("click", function(evt) {
                                  recursions = 0;
                                  if(!isSleeping) {
                                  cancelAnimationFrame(stopRecursion);
                                  onClickCanvas(evt);}});