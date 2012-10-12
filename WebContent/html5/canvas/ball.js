function Ball(x, y, ctx) {
	this.x = x;
	this.y = y;
	this.ctx = ctx;

}

Ball.prototype.draw = function() {
	ctx.clearRect(0, 0, 300, 300);
	ctx.beginPath();
	ctx.arc(this.x, this.y, 10, 0, Math.PI * 2, true);
	ctx.closePath();
	ctx.fill();
	this.x++;
	this.y++;
};
