/**
 * @author THINKER
 */

function draw(points) {
	var ctx = document.getElementById('canvas').getContext('2d');
	var img = new Image();
	img.src = 'back.png';
	img.onload = function() {

		ctx.drawImage(img, 0, 0);
		ctx.beginPath();

		ctx.moveTo(points[0].x, points[0].y);

		for ( var i = 1; i < points.length; i++) {
			ctx.lineTo(points[i].x, points[i].y);
		}

		ctx.stroke();
	};
}