/**
 * @author THINKER
 */

function ImageBall(x, y, ctx, img) {
	this.x = x;
	this.y = y;
	this.ctx = ctx;
	this.img = img;

}

ImageBall.prototype = new Ball(this.x, this.y);

ImageBall.inherits(Ball);

// override
ImageBall.method("draw", function() {

	// alert("draw" + this.x +":"+ this.y);
	var imgObj = new Image();
	imgObj.src = this.img;
	imgObj.target = this;
	imgObj.onload = function() {
		ctx.drawImage(this, this.target.x, this.target.y);
	};

});
