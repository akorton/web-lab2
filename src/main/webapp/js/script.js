const canvas = document.getElementById("canvas");
const ctx = canvas.getContext('2d');
const width = canvas.clientWidth;
const height = canvas.clientHeight;
canvas.width = width;
canvas.height = height;
const maxCoord = 4;
const offsetX = 50;
const offsetY = 50;
const pointSize = 5;
const steps = {'x': (width - offsetX) / (2*maxCoord), 'y': (height - offsetY) / (2*maxCoord)};
const origin = {'x': offsetX / 2 + maxCoord * steps['x'], 'y': offsetY / 2 + maxCoord * steps['y']};
const radiusButtons = document.getElementsByName('radius');
const yButton = document.getElementById('y');
const xButtons = document.getElementById('x_buttons').getElementsByTagName('input');
const formData = document.getElementById('data');
let x = 0;
const hiddenXinput =document.createElement('input');
hiddenXinput.type = 'hidden';
hiddenXinput.name = 'x';
hiddenXinput.value = x;
formData.appendChild(hiddenXinput);
let y = 0;
let r = 1;

let setUp = ()=>{
    ctx.moveTo(origin.x - steps.x * 4, origin.y);
    ctx.lineTo(origin.x + steps.x * 4, origin.y);
    ctx.moveTo(origin.x, origin.y - steps.y * 4);
    ctx.lineTo(origin.x, origin.y + steps.y * 4);
    ctx.stroke();
};

let draw = (r)=>{
    ctx.clearRect(0, 0, width, height);
    setUp();
    ctx.fillStyle = '#0000FF';
    drawRect(r);
    drawTriangle(r);
    drawQuaterCircle(r);
    ctx.beginPath();
};
let drawRect = (r)=>{
    ctx.fillRect(origin.x, origin.y, r*steps.x, r*steps.y);
}
let drawTriangle = (r)=>{
    ctx.beginPath();
    ctx.moveTo(origin.x, origin.y);
    ctx.lineTo(origin.x - r*steps.x / 2, origin.y);
    ctx.lineTo(origin.x, origin.y - r*steps.y / 2);
    ctx.closePath();
    ctx.fill();
}

let drawQuaterCircle = (r)=>{
    ctx.beginPath();
    ctx.moveTo(origin.x, origin.y);
    ctx.arc(origin.x, origin.y, r*steps.x/2, Math.PI * 3/2, 0);
    ctx.fill();
}

let drawPoint = (x, y)=>{
    draw(r);
    ctx.fillStyle = '#FF0000';
    ctx.beginPath();
    ctx.arc(origin.x + x*steps.x, origin.y - y*steps.y, pointSize, 0, Math.PI * 2);
    ctx.fill();
    ctx.beginPath();
}

radiusButtons.forEach((btn)=>{
    btn.addEventListener('click', (e)=>{
        r = btn.value;
        drawPoint(x, y);
    });
});

yButton.addEventListener('input', (e)=>{
    let integerValue = +yButton.value;
    if (Number.isNaN(integerValue) && yButton.value != '-'){
        yButton.value = yButton.value.substring(0, yButton.value.length - 1);
    }
    else if (integerValue > 3 || integerValue < -3){
        yButton.value = yButton.value.substring(0, yButton.value.length - 1);
    }
    if (yButton.value != '-') {
        y = +yButton.value;
        drawPoint(x, y);
    }
});

for (let btn of xButtons){
    btn.addEventListener('click', (e)=>{
        x = +btn.value;
        drawPoint(x, y);
        hiddenXinput.value = x;
    })
}

drawPoint(x, y);