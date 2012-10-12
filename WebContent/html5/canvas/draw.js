var pen;

function Pen(ctx) {
	this.context = ctx;
	this.startX = -1;
	this.startY = -1;
	this.endX = -1;
	this.endY = -1;
	pen = this;
};

Pen.prototype.drawLine = function() {
	pen.context.beginPath();
	pen.context.moveTo(pen.startX, pen.startY);
	pen.context.lineTo(pen.endX, pen.endY);
	pen.context.stroke();
};

Pen.prototype.setStartPoint = function(event) {
	pen.startX = event.offsetX;
	pen.startY = event.offsetY;
};

Pen.prototype.setEndPoint = function(event) {
	pen.endX = event.offsetX;
	pen.endY = event.offsetY;
	pen.drawLine();
};
