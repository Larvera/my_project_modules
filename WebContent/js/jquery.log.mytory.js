/* jquery.log.mytory.js ver 1.0 */
(function($) {
	$.log = function(message) {
		if (debug == true) {
			// if('console' in window && 'log' in window.console)
			if (typeof window.console != 'undefined'
					&& typeof window.console.log != 'undefined') {
				console.log(message);
			}

			var messageHTML =
	            '<pre class="jquery-log-mytory" style="background-color:#000; color:#00ff00; padding:10px; font-size:16px; font-family: 나눔고딕코딩">'
	            + '<span class="jquery-log-mytory-number" style="margin-right: 10px;">1</span>'
	            + message
	            + '</pre>';

			$logDiv = $('.jquery-log-mytory');

			if ($logDiv.length > 0) {
				var number = parseInt( $('.jquery-log-mytory-number:last').text() ) + 1;
	            $logDiv.append("\n" + '<span class="jquery-log-mytory-number" style="margin-right: 10px;">' + number + '</span>' + message);
			} else {
				$('body').prepend(messageHTML);
			}
		}
	};
})(jQuery);