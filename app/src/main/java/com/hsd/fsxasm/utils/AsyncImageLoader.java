package com.hsd.fsxasm.utils;import java.io.File;import android.app.Activity;import android.content.Context;import android.graphics.Bitmap;import android.graphics.Bitmap.CompressFormat;import com.hsd.fsxasm.R;import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;import com.nostra13.universalimageloader.core.DisplayImageOptions;import com.nostra13.universalimageloader.core.ImageLoader;import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;import com.nostra13.universalimageloader.core.assist.ImageScaleType;import com.nostra13.universalimageloader.core.assist.QueueProcessingType;import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;import com.nostra13.universalimageloader.core.download.BaseImageDownloader;import com.nostra13.universalimageloader.utils.StorageUtils;public class AsyncImageLoader {	private static File cacheDir;	private static AsyncImageLoader asyncImageLoader;	private Activity mActivity;	private AsyncImageLoader() {		// TODO Auto-generated constructor stub	}		public static AsyncImageLoader getInstance(){		if(asyncImageLoader==null){			return new AsyncImageLoader();		}else{			return asyncImageLoader;		}	}			public void setCacheDir(String dir){		cacheDir = StorageUtils.getOwnCacheDirectory(mActivity, dir);	}			public ImageLoaderConfiguration getConfig(){				im = new ImageLoaderConfiguration  			    .Builder(mActivity)  			    .memoryCacheExtraOptions(480, 800) // max width, max height，即保存的每个缓存文件的最大长宽  			    .discCacheExtraOptions(480, 800, CompressFormat.JPEG, 75, null) // Can slow ImageLoader, use it carefully (Better don't use it)/设置缓存的详细信息，最好不要设置这个  			    .threadPoolSize(5)//线程池内加载的数量  			    .threadPriority(Thread.NORM_PRIORITY - 2)  			    .denyCacheImageMultipleSizesInMemory()  			    .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024)) // You can pass your own memory cache implementation/你可以通过自己的内存缓存实现  			    .memoryCacheSize(4 * 1024 * 1024)    			    .discCacheSize(50 * 1024 * 1024)    			    .discCacheFileNameGenerator(new Md5FileNameGenerator())//将保存的时候的URI名称用MD5 加密  			    .tasksProcessingOrder(QueueProcessingType.LIFO)  			    .discCacheFileCount(1000) //缓存的文件数量  			    .discCache(new UnlimitedDiscCache(cacheDir))//自定义缓存路径  			    .defaultDisplayImageOptions(setDisplayImageOptions())  			    .imageDownloader(new BaseImageDownloader(mActivity, 5 * 1000, 30 * 1000)) // connectTimeout (5 s), readTimeout (30 s)超时时间  			    .writeDebugLogs() // Remove for release app  			    .build();		return im;	}		private ImageLoaderConfiguration im;	private ImageLoader loader;		public ImageLoader getImageLoaderInstance(Activity activity){		mActivity = activity;		cacheDir = StorageUtils.getOwnCacheDirectory(activity, "fsxasm/Cache");		loader = ImageLoader.getInstance();		loader.init(getConfig());		return loader;	}		public DisplayImageOptions setDisplayImageOptions(){		DisplayImageOptions options;  		options = new DisplayImageOptions.Builder()  		 .showImageOnLoading(R.drawable.ic_defaultphoto) //设置图片在下载期间显示的图片  		 .showImageForEmptyUri(R.drawable.ic_inithead)//设置图片Uri为空或是错误的时候显示的图片  		.showImageOnFail(R.drawable.ic_faiulphoto)  //设置图片加载/解码过程中错误时候显示的图片		.cacheInMemory(true)//设置下载的图片是否缓存在内存中  		.cacheOnDisc(true)//设置下载的图片是否缓存在SD卡中  		.considerExifParams(true)  //是否考虑JPEG图像EXIF参数（旋转，翻转）		.imageScaleType(ImageScaleType.EXACTLY_STRETCHED)//设置图片以如何的编码方式显示  		.bitmapConfig(Bitmap.Config.RGB_565)//设置图片的解码类型//  ARGB_8888		//.decodingOptions(android.graphics.BitmapFactory.Options decodingOptions)//设置图片的解码配置  		//.delayBeforeLoading(int delayInMillis)//int delayInMillis为你设置的下载前的延迟时间		//设置图片加入缓存前，对bitmap进行设置  		//.preProcessor(BitmapProcessor preProcessor)  		.resetViewBeforeLoading(true)//设置图片在下载前是否重置，复位  		.displayer(new RoundedBitmapDisplayer(20))//是否设置为圆角，弧度为多少  		.displayer(new FadeInBitmapDisplayer(100))//是否图片加载好后渐入的动画时间  		.build();//构建完成				return options;	}	}/** *  *  *  *  * String imageUri = "http://site.com/image.png"; // from Web  String imageUri = "file:///mnt/sdcard/image.png"; // from SD card  String imageUri = "content://media/external/audio/albumart/13"; // from content provider  String imageUri = "assets://image.png"; // from assets  String imageUri = "drawable://" + R.drawable.image; // from drawables (only images, non-9patch)  */