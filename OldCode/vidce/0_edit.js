function d(){
	pdx=pdy=pdz=0;
	if(k[65]){
		i=(pcy+90)*p;
		pdx-=.1*(Math.sin(i));
		pdz-=.1*(Math.cos(i))
	}
	if(k[67]){
		pdy-=.1
	}
	if(k[68]){
		i=(pcy+90)*p;
		pdx+=.1*(Math.sin(i));
		pdz+=.1*(Math.cos(i))
	}
	if(k[83]){
		i=pcy*p;
		pdx+=.1*(Math.sin(i));
		pdz+=.1*(Math.cos(i))
	}
	if(k[32]){
		pdy+=.1
	}
	if(k[87]){
		i=pcy*p;
		pdx-=.1*(Math.sin(i));
		pdz-=.1*(Math.cos(i))
	}

	px+=pdx;
	py+=pdy;
	pz+=pdz;

	g.viewport(0,0,w,h);
	g.clear(g.COLOR_BUFFER_BIT|g.DEPTH_BUFFER_BIT);

	mat4.perspective(45,w/h,.1,200,mp);
	
	mat4.identity(mv);
	mat4.rotate(mv,-pcx*p,[1,0,0]);
	mat4.rotate(mv,-pcy*p,[0,1,0]);
	mat4.translate(mv,[-px,-py,-pz]);
	i=v.length-1;
	do{
		var oi=mat4.create();
		mat4.set(mv,oi);
		mvs.push(oi);

		mat4.translate(mv,[v[i][4],v[i][5],v[i][6]]);

		g.bindBuffer(g.ARRAY_BUFFER,v[i][1]);
		g.vertexAttribPointer(vpa,3,g.FLOAT,0,0,0);

		g.bindBuffer(g.ARRAY_BUFFER,v[i][2]);
		g.vertexAttribPointer(vca,4,g.FLOAT,0,0,0);

		g.bindBuffer(g.ELEMENT_ARRAY_BUFFER,v[i][3]);

		g.uniformMatrix4fv(g.getUniformLocation(sp,'uP'),0,mp);
		g.uniformMatrix4fv(g.getUniformLocation(sp,'uM'),0,mv);

		g.drawElements(g.TRIANGLES,6,g.UNSIGNED_SHORT,0);

		mv=mvs.pop()
	}while(i--)
}
function r(){
	w=z('c').width=g.viewportWidth=window.innerWidth;
	h=z('c').height=g.viewportHeight=window.innerHeight
}
function z(i){
	return document.getElementById(i)
}

var g=z('c').getContext('experimental-webgl'),
h=ml=pcx=pcy=pdx=pdy=pdz=pm=px=py=sf=sp=sv=vca=vpa=w=0,
pz=5,
k={},
mp=mat4.create(),
mv=mat4.create(),
mvs=[],
p=Math.PI/180,
v=[
	[0,0,0,0,0,2.5,-5,
		-5,4,-8,
		-5,0,0,
		18,0,0,
		18,4,-8,
		.4,.4,.4,1,
		0,1,0],
	[1,0,0,0,0,-1,-5,
		-5,0,-2,
		-5,0,2,
		8,0,2,
		8,0,-2,
		.3,.3,.3,1,
		0,1,0],
	[2,0,0,0,8,-1.5,-7,
		0,0,0,
		0,0,10,
		10,0,10,
		10,0,0,
		.3,.3,.3,1,
		0,1,0],

	[3,0,0,0,-16,-2,-3,
		0,0,0,
		-1,0,2,
		11,0,2,
		11,0,0,
		.3,.3,.3,1,
		0,1,0],
	[4,0,0,0,-21,-2,-3,
		0,0,-5,
		0,0,-2,
		4,0,2,
		5,0,0,
		.3,.3,.3,1,
		0,1,0],

	[5,0,0,0,-16,8,-3,
		0,2,0,
		0,0,0,
		11,0,0,
		11,2,0,
		.8,.8,.7,1,
		0,0,1],
	[6,0,0,0,-16,6,-3,
		0,2,0,
		0,0,0,
		4,0,0,
		4,2,0,
		.8,.8,.7,1,
		0,0,1],
	[7,0,0,0,-8,6,-3,
		0,2,0,
		0,0,0,
		3,0,0,
		3,2,0,
		.8,.8,.7,1,
		0,0,1],
	[8,0,0,0,-16,4,-3,
		0,2,0,
		0,0,0,
		11,0,0,
		11,2,0,
		.8,.8,.7,1,
		0,0,1],
	[9,0,0,0,-16,2,-3,
		0,2,0,
		0,0,0,
		4,0,0,
		4,2,0,
		.8,.8,.7,1,
		0,0,1],
	[10,0,0,0,-8,2,-3,
		0,2,0,
		0,0,0,
		3,0,0,
		3,2,0,
		.8,.8,.7,1,
		0,0,1],
	[11,0,0,0,-16,0,-3,
		0,2,0,
		0,0,0,
		11,0,0,
		11,2,0,
		.8,.8,.7,1,
		0,0,1],
	[12,0,0,0,-16,-2,-3,
		0,2,0,
		0,0,0,
		11,0,0,
		11,2,0,
		.4,.4,.4,1,
		0,0,1],

	[13,0,0,0,5,2,-7,
		0,1,0,
		0,0,0,
		12,0,0,
		12,1,0,
		.8,.8,.7,1,
		0,0,1],
	[14,0,0,0,0,2,-7,
		-5,1,0,
		-5,0,0,
		2,0,0,
		2,1,0,
		.8,.8,.7,1,
		0,0,1],
	[15,0,0,0,-3,0,-7,
		0,2,0,
		0,0,0,
		2,0,0,
		2,2,0,
		.8,.8,.7,1,
		0,0,1],
	[16,0,0,0,2,0,-7,
		0,3,0,
		0,0,0,
		3,0,0,
		3,3,0,
		.8,.8,.7,1,
		0,0,1],
	[17,0,0,0,0,-1,-7,
		-3,1,0,
		-3,0,0,
		5,0,0,
		5,1,0,
		.4,.4,.4,1,
		0,0,1],
	[18,0,0,0,-5,-1,-7,
		0,3,0,
		0,0,0,
		2,0,0,
		2,3,0,
		.5,.2,0,1,
		0,0,1],
	
	[19,0,0,0,7,0,-7,
		0,3,0,
		0,0,0,
		1.5,0,0,
		1.5,3,0,
		.8,.8,.7,1,
		0,0,1],
	[20,0,0,0,7,-1.5,-7,
		0,1.5,0,
		0,0,0,
		1.5,0,0,
		1.5,1.5,0,
		.4,.4,.4,1,
		0,0,1],
	[21,0,0,0,17,0,-7,
		0,3,0,
		0,0,0,
		1,0,0,
		1,3,0,
		.8,.8,.7,1,
		0,0,1],
	[22,0,0,0,17,-1.5,-7,
		0,1.5,0,
		0,0,0,
		1,0,0,
		1,1.5,0,
		.4,.4,.4,1,
		0,0,1],

	[23,0,0,0,8,-1.5,-7,
		0,0,0,
		0,.5,0,
		0,.5,4,
		0,0,4,
		.4,.4,.4,1,
		1,0,0],

	[24,0,0,0,-5,-1.5,-3,
		13,0,0,
		13,.5,0,
		0,.5,0,
		0,0,0,
		.4,.4,.4,1,
		0,0,1],

	[25,0,0,0,-5,-1,-7,
		0,0,0,
		0,1,0,
		0,1,4,
		0,0,4,
		.4,.4,.4,1,
		1,0,0],
	[26,0,0,0,-5,0,-7,
		0,0,0,
		0,2,0,
		0,2,4,
		0,0,4,
		.7,.7,.6,1,
		1,0,0],
	[27,0,0,0,-5,2,-7,
		0,0,0,
		0,1,0,
		0,1,1,
		0,0,1,
		.7,.7,.6,1,
		1,0,0],
	[28,0,0,0,-5,2,-5,
		0,0,0,
		0,1,0,
		0,1,2,
		0,0,2,
		.7,.7,.6,1,
		1,0,0],
	[29,0,0,0,-5,3,-7,
		0,0,0,
		0,5,0,
		0,5,4,
		0,0,4,
		.7,.7,.6,1,
		1,0,0],

	[30,0,0,0,18,0,-16,
		0,0,0,
		0,3,0,
		0,3,9,
		0,0,9,
		.7,.7,.6,1,
		1,0,0],

	[31,0,0,0,18,-1.5,-16,
		0,0,0,
		0,1.5,0,
		0,1.5,9,
		0,0,9,
		.4,.4,.4,1,
		1,0,0]
];

r();
window.onresize=r;

sf=g.createShader(g.FRAGMENT_SHADER);
g.shaderSource(sf,'precision mediump float;varying lowp vec4 vC;void main(void){gl_FragColor=vC;}');
g.compileShader(sf);

sv=g.createShader(g.VERTEX_SHADER);
g.shaderSource(sv,'attribute vec4 aVC;attribute vec3 aVP;uniform mat4 uM;uniform mat3 uN;uniform mat4 uP;uniform vec3 uLL;varying lowp vec4 vC;void main(void){vec4 mVP=uM*vec4(aVP,1);gl_Position=uP*mVP;vC=aVC;}');
g.compileShader(sv);

g.clearColor(0,0,0,1);
g.clearDepth(1);
g.enable(g.CULL_FACE);
g.enable(g.DEPTH_TEST);
g.depthFunc(g.LEQUAL);

sp=g.createProgram();
g.attachShader(sp,sv);
g.attachShader(sp,sf);
g.linkProgram(sp);
g.useProgram(sp);

vpa=g.getAttribLocation(sp,'aVP');
g.enableVertexAttribArray(vpa);

vca=g.getAttribLocation(sp,'aVC');
g.enableVertexAttribArray(vca);

var i=v.length-1;
do{
	v[i][1]=g.createBuffer();
	g.bindBuffer(g.ARRAY_BUFFER,v[i][1]);
	g.bufferData(g.ARRAY_BUFFER,new Float32Array([
		v[i][7],v[i][8],v[i][9],
		v[i][10],v[i][11],v[i][12],
		v[i][13],v[i][14],v[i][15],
		v[i][16],v[i][17],v[i][18]
	]),g.STATIC_DRAW);

	v[i][2]=g.createBuffer();
	g.bindBuffer(g.ARRAY_BUFFER,v[i][2]);
	g.bufferData(g.ARRAY_BUFFER,new Float32Array([
		v[i][19],v[i][20],v[i][21],v[i][22],
		v[i][19],v[i][20],v[i][21],v[i][22],
		v[i][19],v[i][20],v[i][21],v[i][22],
		v[i][19],v[i][20],v[i][21],v[i][22]
	]),g.STATIC_DRAW);

	v[i][3]=g.createBuffer();
	g.bindBuffer(g.ELEMENT_ARRAY_BUFFER,v[i][3]);
	g.bufferData(g.ELEMENT_ARRAY_BUFFER,new Uint16Array([
		0,1,2,0,2,3
	]),g.STATIC_DRAW)
}while(i--);

setInterval('d()',40);

window.onkeydown=function(e){
	i=window.event?event:e;
	k[i.charCode?i.charCode:i.keyCode]=1;
	if(k[72]){
		px=py=pz=0
	}
};
window.onkeyup=function(e){
	i=window.event?event:e;
	k[i.charCode?i.charCode:i.keyCode]=0
};
window.onmousedown=function(e){
	ml=1
};
window.onmousemove=function(e){
	if(ml){
		pcx+=-(e.movementY||e.mozMovementY||e.webkitMovementY)/5;
		if(pcx>89){
			pcx=89
		}else if(pcx<-89){
			pcx=-89
		}
		pcy+=-(e.movementX||e.mozMovementX||e.webkitMovementX)/5;
		if(pcy>360){
			pcy-=360
		}else if(pcy<0){
			pcy+=360
		}
	}
};
window.onmouseup=function(e){
	ml=0
}
