
	/**
	 * HTTP URL 체크
	 * @param urls
	 * @returns {Boolean}
	 */
	function isValidUrl(url) {
		var chkExp = /http:\/\/([\w\-]+\.)+/g;
		if (chkExp.test(url) == false) {
			return false;
		}
		return true;
	}

	/**
	 * 입력값 null체크
	 * @param input
	 * @returns {Boolean}
	 */
	function isNull(input) {
	    if (input.value == null || input.value == "") {
	        return true;
	    }
	    return false;
	}

	/**
	 * 입력값에 스페이스 이외의 의미있는 값이 있는지 체크
	 */
	function isEmpty(input) {
	    if (input.value == null || input.value.replace(/ /gi, "") == "") {
	        return true;
	    }
	    return false;
	}

	/**
	 * 입력값에 특정 문자(chars)가 있는지 체크
	 * 특정 문자를 허용하지 않으려 할 때 사용
	 * ex) if (containsChars(form.name,"!,*&^%$#@~;")) {
	 *         alert("이름 필드에는 특수 문자를 사용할 수 없습니다.");
	 *     }
	 */
	function containsChars(input,chars) {
	    for (var inx = 0; inx < input.value.length; inx++) {
	       if (chars.indexOf(input.value.charAt(inx)) != -1) {
			return true;
		}
	    }
	    return false;
	}

	/**
	 * 입력값이 특정 문자(chars)만으로 되어있는지 체크
	 * 특정 문자만 허용하려 할 때 사용
	 * ex) if (!containsCharsOnly(form.blood,"ABO")) {
	 *         alert("혈액형 필드에는 A,B,O 문자만 사용할 수 있습니다.");
	 *     }
	 */
	function containsCharsOnly(input,chars) {
	    for (var inx = 0; inx < input.value.length; inx++) {
	       if (chars.indexOf(input.value.charAt(inx)) == -1) {
			return false;
		}
	    }
	    return true;
	}

	/**
	 * 입력값이 알파벳인지 체크
	 * 아래 isAlphabet() 부터 isNumComma()까지의 메소드가
	 * 자주 쓰이는 경우에는 var chars 변수를
	 * global 변수로 선언하고 사용하도록 한다.
	 * ex) var uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	 *     var lowercase = "abcdefghijklmnopqrstuvwxyz";
	 *     var number    = "0123456789";
	 *     function isAlphaNum(input) {
	 *         var chars = uppercase + lowercase + number;
	 *         return containsCharsOnly(input,chars);
	 *     }
	 */
	function isAlphabet(input) {
	    var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	    return containsCharsOnly(input,chars);
	}

	/**
	 * 입력값이 알파벳 대문자인지 체크
	 */
	function isUpperCase(input) {
	    var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    return containsCharsOnly(input,chars);
	}

	/**
	 * 입력값이 알파벳 소문자인지 체크
	 */
	function isLowerCase(input) {
	    var chars = "abcdefghijklmnopqrstuvwxyz";
	    return containsCharsOnly(input,chars);
	}

	/**
	 * 입력값에 숫자만 있는지 체크
	 */
	function isNumber(input) {
	    var chars = "0123456789";
	    return containsCharsOnly(input,chars);
	}

	/**
	 * 입력값이 알파벳,숫자로 되어있는지 체크
	 */
	function isAlphaNum(input) {
	    var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    return containsCharsOnly(input,chars);
	}

	/**
	 * 입력값이 숫자,대시(-)로 되어있는지 체크
	 */
	function isNumDash(input) {
	    var chars = "-0123456789";
	    return containsCharsOnly(input,chars);
	}

	/**
	 * 입력값이 숫자,콤마(,)로 되어있는지 체크
	 */
	function isNumComma(input) {
	    var chars = ",0123456789";
	    return containsCharsOnly(input,chars);
	}

	/**
	 * 입력값에서 콤마를 없앤다.
	 */
	function removeComma(input) {
	    return input.value.replace(/,/gi,"");
	}

	/**
	 * 입력값이 사용자가 정의한 포맷 형식인지 체크
	 * 자세한 format 형식은 자바스크립트의 'regular expression'을 참조
	 */
	function isValidFormat(input,format) {
	    if (input.value.search(format) != -1) {
	        return true; //올바른 포맷 형식
	    }
	    return false;
	}

	/**
	 * 입력값이 이메일 형식인지 체크
	 */
	function isValidEmail(input) {
//	    var format = /^(\S+)@(\S+)\.([A-Za-z]+)$/;
	    var format = /^((\w|[\-\.])+)@((\w|[\-\.])+)\.([A-Za-z]+)$/;
	    return isValidFormat(input,format);
	}

	/**
	 * 입력값이 전화번호 형식(숫자-숫자-숫자)인지 체크
	 */
	function isValidPhone(input) {
	    var format = /^(\d+)-(\d+)-(\d+)$/;
	    return isValidFormat(input,format);
	}

	/**
	 * 선택된 라디오버튼이 있는지 체크
	 */
	function hasCheckedRadio(input) {
	    if (input.length > 1) {
	        for (var inx = 0; inx < input.length; inx++) {
	            if (input[inx].checked) {
					return true;
				}
	        }
	    } else {
	        if (input.checked) {
				return true;
			}
	    }
	    return false;
	}

	/**
	 * 선택된 체크박스가 있는지 체크
	 */
	function hasCheckedBox(input) {
	    return hasCheckedRadio(input);
	}

	/**
	 * 입력값의 바이트 길이를 리턴
	 * Author : Wonyoung Lee
	 */
	function getByteLength(input) {
	    var byteLength = 0;
	    for (var inx = 0; inx < input.value.length; inx++) {
	        var oneChar = escape(input.value.charAt(inx));
	        if ( oneChar.length == 1 ) {
	            byteLength ++;
	        } else if (oneChar.indexOf("%u") != -1) {
	            byteLength += 2;
	        } else if (oneChar.indexOf("%") != -1) {
	            byteLength += oneChar.length/3;
	        }
	    }
	    return byteLength;
	}


	// 한글이외의 캐릭터가 있을경우 false
	// 한자나 숫자 영문의 경우 false
	function checkKoreanOnly( koreanChar ) {
	    if ( koreanChar == null ) {
			return false ;
		}

	    for(var i=0; i < koreanChar.length; i++){
	        var c=koreanChar.charCodeAt(i);

	        //( 0xAC00 <= c && c <= 0xD7A3 ) 초중종성이 모인 한글자
	        //( 0x3131 <= c && c <= 0x318E ) 자음 모음
	        if( !( ( 0xAC00 <= c && c <= 0xD7A3 ) || ( 0x3131 <= c && c <= 0x318E ) ) ) {
	            return false ;
	        }
	    }

	    return true ;
	}
