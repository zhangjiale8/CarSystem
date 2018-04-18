$(function() {
	var setTime;
	$(".egc-top .nav-cent .operate").hover(
			function() {
				var _this = $(this);
				setTime = setTimeout(function() {
					_this.find(".sec-version").slideDown(200);
					_this.find("i").removeClass("icon-angle-down").addClass(
							"icon-angle-up");
				}, 200);
			},
			function() {
				if (setTime) {
					clearTimeout(setTime);
				}
				$(".egc-top .nav-cent .sec-version").slideUp(200);
				$(".egc-top .nav-cent .operate i").removeClass("icon-angle-up")
						.addClass("icon-angle-down");
			});
	$('.menu-mb i').click(function() {
		$(".navigation-mb-list").slideDown(300);
	});
	$('.navigation-mb-list .list-close-btn').click(function() {
		$(".navigation-mb-list").slideUp(300);
	});
	var scroll_heitht = $('body').offset().top;
	var isShow = true;
	$(window).scroll(function() {
		if ($(window).scrollTop() > scroll_heitht && isShow) {
			$('.stress-search-box').slideDown(200);
		} else {
			$('.stress-search-box').slideUp(200);
		}
	});
	$('.stress-close a').click(function() {
		isShow = false;
		$('.stress-search-box').slideUp(200).unbind(window, aa);
	});
	$('.all-sort-list > .item').hover(
			function() {
				var eq = $('.all-sort-list >.item').index(this), // 获取当前滑过是第几个元素
				h = $('.all-sort-list').offset().top, // 获取当前下拉菜单距离窗口多少像素
				s = $(window).scrollTop(), // 获取游览器滚动了多少高度
				i = $(this).offset().top, // 当前元素滑过距离窗口多少像素
				item = $(this).children('.item-list').height(), // 下拉菜单子类内容容器的高度
				sort = $('.all-sort-list').height(); // 父类分类列表容器的高度

				if (item < sort) { // 如果子类的高度小于父类的高度
					if (eq == 0) {
						$(this).children('.item-list').css('top', (i - h));
					} else {
						$(this).children('.item-list').css('top', (i - h));
					}
				} else {
					if (s > h) { // 判断子类的显示位置，如果滚动的高度大于所有分类列表容器的高度
						if (i - s > 0) { // 则 继续判断当前滑过容器的位置
											// 是否有一半超出窗口一半在窗口内显示的Bug,
							$(this).children('.item-list').css('top',
									(s - h) + 2);
						} else {
							$(this).children('.item-list').css('top',
									(s - h) - (-(i - s)) + 2);
						}
					} else {
						$(this).children('.item-list').css('top', 0);
					}
				}

				$(this).addClass('hover');
				$(this).children('.item-list').css('display', 'block');
			}, function() {
				$(this).removeClass('hover');
				$(this).children('.item-list').css('display', 'none');
			});

	$('.item > .item-list > .close').click(function() {
		$(this).parent().parent().removeClass('hover');
		$(this).parent().hide();
	});
	$('.navmenu li').hover(function() {
		$('span', this).stop().css('height', '2px');
		$('span', this).animate({
			left : '0',
			width : '100%',
			right : '0'
		}, 200);
	}, function() {
		$('span', this).stop().animate({
			left : '50%',
			width : '0'
		}, 200);
	});
	$("#leftsead a").hover(function() {
		if ($(this).prop("className") == "youhui") {
			$(this).children("img.hides").show();
		} else {
			$(this).children("img.hides").show();
			$(this).children("img.shows").hide();
			$(this).children("img.hides").animate({
				marginRight : '0px'
			}, 'slow');
		}
	}, function() {
		if ($(this).prop("className") == "youhui") {
			$(this).children("img.hides").hide('slow');
		} else {
			$(this).children("img.hides").animate({
				marginRight : '-143px'
			}, 'slow', function() {
				$(this).hide();
				$(this).next("img.shows").show();
			});
		}
	});

	$("#top_btn").click(function() {
		if (scroll == "off")
			return;
		$("html,body").animate({
			scrollTop : 0
		}, 600);
	});
	$('.flexslider').flexslider({
		directionNav : true,
		pauseOnAction : false
	});
	$('.flexslider').hover(function() {
		$('.flex-direction-nav').fadeIn();
	}, function() {
		$('.flex-direction-nav').fadeOut();
	});
	$(function() {
		$('.sea-ipt-txt').focus(function() {
			$(this).addClass("on");
			$('.search-btn').addClass("on");
		});
		$('.sea-ipt-txt').blur(function() {
			$(this).removeClass("on");
			$('.search-btn').removeClass("on");
		});
	});
});