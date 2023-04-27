package com.moddownloader.Mr.D;

import android.Manifest;
import android.animation.*;
import android.animation.ObjectAnimator;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.webkit.*;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.*;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.downloader.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class DownloaderActivity extends Activity {
	
	private Timer _timer = new Timer();
	private double id = 0;
	private boolean ld = false;
	private boolean lr = false;
	private LinearLayout linear1;
	private WebView webview1;
	private ImageView imageview1;
	private LinearLayout linear2;
	private ImageView imageview2;
	private ImageView imageview3;
	private EditText edittext1;
	private ProgressBar progressbar1;
	private ObjectAnimator oa = new ObjectAnimator();
	private TimerTask t;

	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.downloader);
		initialize(_savedInstanceState);

		if (Build.VERSION.SDK_INT >= 23) {
			if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
			||checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
				requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
			} else {
				initializeLogic();
			}
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		webview1 = findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		imageview1 = findViewById(R.id.imageview1);
		linear2 = findViewById(R.id.linear2);
		imageview2 = findViewById(R.id.imageview2);
		imageview3 = findViewById(R.id.imageview3);
		edittext1 = findViewById(R.id.edittext1);
		progressbar1 = findViewById(R.id.progressbar1);

		webview1.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				super.onPageFinished(_param1, _param2);
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_a(imageview1, 1.1d);
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_a(imageview1, 1);
								/*set the custom view id here*/
								View popup = getLayoutInflater().inflate(R.layout.tii, null);
								final PopupWindow pop__up = new PopupWindow(popup, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
								/*here you will define the needed views to give it events*/
								final TextView but1 = popup.findViewById(R.id.textview1);
								final TextView but2 = popup.findViewById(R.id.textview2);
								final TextView but3 = popup.findViewById(R.id.textview3);
								final TextView but4 = popup.findViewById(R.id.textview4);
								final TextView but5 = popup.findViewById(R.id.textview5);
								final TextView but6 = popup.findViewById(R.id.textview6);
								final TextView but7 = popup.findViewById(R.id.textview7);
								final TextView but8 = popup.findViewById(R.id.textview8);
								final TextView but9 = popup.findViewById(R.id.textview9);
								final TextView but10 = popup.findViewById(R.id.textview10);
								final TextView but11 = popup.findViewById(R.id.textview11);
								final TextView but12 = popup.findViewById(R.id.textview12);
								final TextView but13 = popup.findViewById(R.id.textview13);
								final TextView but14 = popup.findViewById(R.id.textview14);
								/*here you will enter the id of view that pop up will be show when it clicked*/
								pop__up.setAnimationStyle(android.R.style.Animation_Dialog);
								pop__up.showAsDropDown(imageview1, 0,0);
								if (id == 0) {
										_e(but1, but2, but3, but4, but5, but6, but7, but8, but9, but10, but11, but12, but13);
								} else if (id == 1) {
										_e(but2, but1, but3, but4, but5, but6, but7, but8, but9, but10, but11, but12, but13);
								} else if (id == 2) {
										_e(but3, but2, but1, but4, but5, but6, but7, but8, but9, but10, but11, but12, but13);
								} else if (id == 3) {
										_e(but4, but2, but3, but1, but5, but6, but7, but8, but9, but10, but11, but12, but13);
								} else if (id == 4) {
										_e(but5, but2, but3, but4, but1, but6, but7, but8, but9, but10, but11, but12, but13);
								} else if (id == 5) {
										_e(but6, but2, but3, but4, but5, but1, but7, but8, but9, but10, but11, but12, but13);
								} else if (id == 6) {
										_e(but7, but2, but3, but4, but5, but6, but1, but8, but9, but10, but11, but12, but13);
								} else if (id == 7) {
										_e(but8, but2, but3, but4, but5, but6, but7, but1, but9, but10, but11, but12, but13);
								} else if (id == 8) {
										_e(but9, but2, but3, but4, but5, but6, but7, but8, but1, but10, but11, but12, but13);
								} else if (id == 9) {
										_e(but10, but2, but3, but4, but5, but6, but7, but8, but9, but1, but11, but12, but13);
								} else if (id == 10) {
										_e(but11, but2, but3, but4, but5, but6, but7, but8, but9, but10, but1, but12, but13);
								} else if (id == 11) {
										_e(but12, but2, but3, but4, but5, but6, but7, but8, but9, but10, but11, but1, but13);
								} else if (id == 12) {
										_e(but13, but2, but3, but4, but5, but6, but7, but8, but9, but10, but11, but12, but1);
								}
								but14.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFFF8F00));
								but14.setElevation((float)10);
								but1.setTypeface(Typeface.SERIF);
								but2.setTypeface(Typeface.SERIF);
								but3.setTypeface(Typeface.SERIF);
								but4.setTypeface(Typeface.SERIF);
								but5.setTypeface(Typeface.SERIF);
								but6.setTypeface(Typeface.SERIF);
								but7.setTypeface(Typeface.SERIF);
								but8.setTypeface(Typeface.SERIF);
								but9.setTypeface(Typeface.SERIF);
								but10.setTypeface(Typeface.SERIF);
								but11.setTypeface(Typeface.SERIF);
								but12.setTypeface(Typeface.SERIF);
								but13.setTypeface(Typeface.SERIF);
								but14.setTypeface(Typeface.SERIF);
								but1.setOnClickListener(new View.OnClickListener() {
										@Override
										public void onClick(View _view) {
												id = 0;
												webview1.loadUrl("https://a2zapk.com/");
												pop__up.dismiss();
										}
								});
								but2.setOnClickListener(new View.OnClickListener() {
										@Override
										public void onClick(View _view) {
												id = 1;
												webview1.loadUrl("https://an1.com/");
												pop__up.dismiss();
										}
								});
								but3.setOnClickListener(new View.OnClickListener() {
										@Override
										public void onClick(View _view) {
												id = 2;
												webview1.loadUrl("https://www.apkdlmod.com/");
												pop__up.dismiss();
										}
								});
								but4.setOnClickListener(new View.OnClickListener() {
										@Override
										public void onClick(View _view) {
												id = 3;
												webview1.loadUrl("https://apkmody.io/");
												pop__up.dismiss();
										}
								});
								but5.setOnClickListener(new View.OnClickListener() {
										@Override
										public void onClick(View _view) {
												id = 4;
												webview1.loadUrl("https://dlandroid.com/");
												pop__up.dismiss();
										}
								});
								but6.setOnClickListener(new View.OnClickListener() {
										@Override
										public void onClick(View _view) {
												id = 5;
												webview1.loadUrl("https://happymod.com/");
												pop__up.dismiss();
										}
								});
								but7.setOnClickListener(new View.OnClickListener() {
										@Override
										public void onClick(View _view) {
												id = 6;
												webview1.loadUrl("https://modbigs.com/");
												pop__up.dismiss();
										}
								});
								but8.setOnClickListener(new View.OnClickListener() {
										@Override
										public void onClick(View _view) {
												id = 7;
												webview1.loadUrl("https://modcombo.com/");
												pop__up.dismiss();
										}
								});
								but9.setOnClickListener(new View.OnClickListener() {
										@Override
										public void onClick(View _view) {
												id = 8;
												webview1.loadUrl("https://www.moddb.com/");
												pop__up.dismiss();
										}
								});
								but10.setOnClickListener(new View.OnClickListener() {
										@Override
										public void onClick(View _view) {
												id = 9;
												webview1.loadUrl("https://moddroid.co/");
												pop__up.dismiss();
										}
								});
								but11.setOnClickListener(new View.OnClickListener() {
										@Override
										public void onClick(View _view) {
												id = 10;
												webview1.loadUrl("https://rajaapk.com/");
												pop__up.dismiss();
										}
								});
								but12.setOnClickListener(new View.OnClickListener() {
										@Override
										public void onClick(View _view) {
												id = 11;
												webview1.loadUrl("https://www.revdl.com/");
												pop__up.dismiss();
										}
								});
								but13.setOnClickListener(new View.OnClickListener() {
										@Override
										public void onClick(View _view) {
												id = 12;
												webview1.loadUrl("https://rexdl.com/");
												pop__up.dismiss();
										}
								});
								but14.setOnClickListener(new View.OnClickListener() {
										@Override
										public void onClick(View _view) {
												pop__up.dismiss();
										}
								});
							}
						});
					}
				};
				_timer.schedule(t, (int)(200));
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_a(imageview2, 1.1d);
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_a(imageview2, 1);
								webview1.loadUrl(webview1.getUrl());
							}
						});
					}
				};
				_timer.schedule(t, (int)(200));
			}
		});

		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_a(imageview3, 1.1d);
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_a(imageview3, 1);
								/*set the custom view id here*/
								View pop_upV = getLayoutInflater().inflate(R.layout.cont, null);
								final PopupWindow pop_up = new PopupWindow(pop_upV, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
								/*here you will define the needed views to give it events*/
								final TextView but1 = pop_upV.findViewById(R.id.textview1);
								final TextView but2 = pop_upV.findViewById(R.id.textview2);
								final TextView but3 = pop_upV.findViewById(R.id.textview3);
								final TextView but4 = pop_upV.findViewById(R.id.textview4);
								/*here you will enter the id of view that pop up will be show when it clicked*/
								pop_up.setAnimationStyle(android.R.style.Animation_Dialog);
								pop_up.showAsDropDown(imageview3, 0,0);
								but1.setTypeface(Typeface.SERIF);
								but2.setTypeface(Typeface.SERIF);
								but3.setTypeface(Typeface.SERIF);
								but4.setTypeface(Typeface.SERIF);
								but1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFFFFFFF));
								but1.setElevation((float)10);
								but2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFFFFFFF));
								but2.setElevation((float)10);
								but3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFFF8F00));
								but3.setElevation((float)10);
								but4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFC62828));
								but4.setElevation((float)10);
								but1.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
										_a(but1, 1.1d);
										t = new TimerTask() {
											@Override
											public void run() {
												runOnUiThread(new Runnable() {
													@Override
													public void run() {
														_a(but1, 1);
														String apk = "Mod Downloader";
														String uri = (getApplicationContext().getPackageName());
														try {
																android.content.pm.PackageInfo pi = getPackageManager().getPackageInfo(uri, android.content.pm.PackageManager.GET_ACTIVITIES);
																apk = pi.applicationInfo.publicSourceDir;
														} catch (Exception e) {
																showMessage(e.toString());
														}
														Intent iten = new Intent(Intent.ACTION_SEND);
														iten.setType("*/*");
														iten.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new java.io.File(apk)));
														
														startActivity(Intent.createChooser(iten, "Bagikan ke....."));
														pop_up.dismiss();
													}
												});
											}
										};
										_timer.schedule(t, (int)(200));
									}
								});
								but2.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
										_a(but2, 1.1d);
										t = new TimerTask() {
											@Override
											public void run() {
												runOnUiThread(new Runnable() {
													@Override
													public void run() {
														_a(but2, 1);
														if (ld) {
															_f();
															ld = false;
														} else {

															showMessage("Tidak ada aktivitas unduhan !!!");
														}

														pop_up.dismiss();
													}
												});
											}
										};
										_timer.schedule(t, (int)(200));
									}
								});
								but3.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
										_a(but3, 1.1d);
										t = new TimerTask() {
											@Override
											public void run() {
												runOnUiThread(new Runnable() {
													@Override
													public void run() {
														_a(but3, 1);
														pop_up.dismiss();
													}
												});
											}
										};
										_timer.schedule(t, (int)(200));
									}
								});
								but4.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
										_a(but4, 1.1d);
										t = new TimerTask() {
											@Override
											public void run() {
												runOnUiThread(new Runnable() {
													@Override
													public void run() {
														_a(but4, 1);
														_d();
													}
												});
											}
										};
										_timer.schedule(t, (int)(200));
									}
								});
							}
						});
					}
				};
				_timer.schedule(t, (int)(200));
			}
		});
	}

	private void initializeLogic() {
		_c();
	}

	@Override
	public void onBackPressed() {
		if (webview1.canGoBack()) {
			webview1.goBack();
			t = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							if (edittext1.getText().toString().contains("a2zapk")) {
									id = 0;
							} else if (edittext1.getText().toString().contains("an1")) {
									id = 1;
							} else if (edittext1.getText().toString().contains("apkdlmod")) {
									id = 2;
							} else if (edittext1.getText().toString().contains("apkmody")) {
									id = 3;
							} else if (edittext1.getText().toString().contains("dlandroid")) {
									id = 4;
							} else if (edittext1.getText().toString().contains("happymod")) {
									id = 5;
							} else if (edittext1.getText().toString().contains("modbigs")) {
									id = 6;
							} else if (edittext1.getText().toString().contains("modcombo")) {
									id = 7;
							} else if (edittext1.getText().toString().contains("moddb")) {
									id = 8;
							} else if (edittext1.getText().toString().contains("moddroid")) {
									id = 9;
							} else if (edittext1.getText().toString().contains("rajaapk")) {
									id = 10;
							} else if (edittext1.getText().toString().contains("revdl")) {
									id = 11;
							} else if (edittext1.getText().toString().contains("rexdl")) {
									id = 12;
							}
						}
					});
				}
			};
			_timer.schedule(t, (int)(150));
		} else {
			_d();
		}
	}

	public void _a(final View _a, final double _b) {
		oa.setTarget(_a);
		oa.setPropertyName("scaleX");
		oa.setPropertyName("scaleY");
		oa.setFloatValues((float)(_b));
		oa.setDuration((int)(200));
		oa.start();
	}

	public void _b() {
	}
	private long downloadID;
	public void _e(final TextView _a, final TextView _b, final TextView _c, final TextView _d, final TextView _e, final TextView _f, final TextView _g, final TextView _h, final TextView _i, final TextView _j, final TextView _k, final TextView _l, final TextView _m) {
		_a.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFFFEB3B));
		_a.setElevation((float)10);
		_b.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFFFFFFF));
		_b.setElevation((float)10);
		_c.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFFFFFFF));
		_c.setElevation((float)10);
		_d.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFFFFFFF));
		_d.setElevation((float)10);
		_e.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFFFFFFF));
		_e.setElevation((float)10);
		_f.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFFFFFFF));
		_f.setElevation((float)10);
		_g.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFFFFFFF));
		_g.setElevation((float)10);
		_h.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFFFFFFF));
		_h.setElevation((float)10);
		_i.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFFFFFFF));
		_i.setElevation((float)10);
		_j.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFFFFFFF));
		_j.setElevation((float)10);
		_k.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFFFFFFF));
		_k.setElevation((float)10);
		_l.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFFFFFFF));
		_l.setElevation((float)10);
		_m.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFFFFFFF));
		_m.setElevation((float)10);
	}

	public void _c() {
		webview1.loadUrl("https://a2zapk.com");
		progressbar1.setVisibility(View.GONE);
		linear2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFFFFFFF));
		linear2.setElevation((float)10);
		edittext1.setTypeface(Typeface.SERIF);
		webview1.setDownloadListener(new DownloadListener() {
				@Override
				 public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
						DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
						request.setTitle(URLUtil.guessFileName(url, contentDisposition, mimetype));
						request.setDescription("Unduh file.....");
						request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
						request.setDestinationInExternalPublicDir("/Mr. Đ", URLUtil.guessFileName(url, contentDisposition, mimetype));
						DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
				       downloadID = dm.enqueue(request);
				        ld = true;
						Toast.makeText(getApplicationContext(), "Mengunduh", Toast.LENGTH_SHORT).show();
						registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
				}
				BroadcastReceiver onComplete = new BroadcastReceiver() {
						@Override public void onReceive(Context context, Intent intent) {
								ld = false;
					Toast.makeText(getApplicationContext(), "Unduhan selesai", Toast.LENGTH_SHORT).show();
						}
						 };
				 });
		edittext1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
				@Override
				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
						if (actionId == 3) {
								if (id == 0) {
										webview1.loadUrl("https://a2zapk.com/Search/".concat(edittext1.getText().toString().replace(" ", "%20").concat("/")));
								} else if (id == 1) {
										webview1.loadUrl("https://an1.com/?story=".concat(edittext1.getText().toString().replace(" ", "+").concat("&do=search&subaction=search")));
								} else if (id == 2) {
										webview1.loadUrl("https://www.apkdlmod.com/?s=".concat(edittext1.getText().toString().replace(" ", "+")));
								} else if (id == 3) {
										webview1.loadUrl("https://apkmody.io/?s=".concat(edittext1.getText().toString().replace(" ", "+")));
								} else if (id == 4) {
										webview1.loadUrl("https://dlandroid.com/?s=".concat(edittext1.getText().toString().replace(" ", "+")));
								} else if (id == 5) {
										webview1.loadUrl("https://happymod.com/search.html?q=".concat(edittext1.getText().toString().replace(" ", "+")));
								} else if (id == 6) {
										webview1.loadUrl("https://modbigs.com/?s=".concat(edittext1.getText().toString().replace(" ", "+")));
								} else if (id == 7) {
										webview1.loadUrl("https://modcombo.com/id/?s=".concat(edittext1.getText().toString().replace(" ", "+")));
								} else if (id == 8) {
										webview1.loadUrl("https://www.moddb.com/search?q=".concat(edittext1.getText().toString().replace(" ", "+").concat("&sa.x=0&sa.y=0")));
								} else if (id == 9) {
										webview1.loadUrl("https://moddroid.co/search/?s=".concat(edittext1.getText().toString().replace(" ", "+")));
								} else if (id == 10) {
										webview1.loadUrl("https://rajaapk.com/?s=".concat(edittext1.getText().toString().replace(" ", "+")));
								} else if (id == 11) {
										webview1.loadUrl("https://www.revdl.com/?s=".concat(edittext1.getText().toString().replace(" ", "+")));
								} else if (id == 12) {
										webview1.loadUrl("https://rexdl.com/?s=".concat(edittext1.getText().toString().replace(" ", "+")));
								}
						}
						return false;
				}
		});
	}

	public void _d() {
		final AlertDialog dialog = new AlertDialog.Builder(DownloaderActivity.this).create();
		LayoutInflater inflater = getLayoutInflater();
		View convertView = (View) inflater.inflate(R.layout.d11, null);
		dialog.setView(convertView);
		dialog.setCancelable(false);
		final TextView tex1 = (TextView) convertView.findViewById(R.id.textview1);
		final TextView tex2 = (TextView) convertView.findViewById(R.id.textview2);
		final TextView tex3 = (TextView) convertView.findViewById(R.id.textview3);
		final LinearLayout l1 = (LinearLayout) convertView.findViewById(R.id.linear1);
		tex1.setTypeface(Typeface.SERIF);
		tex2.setTypeface(Typeface.SERIF);
		tex3.setTypeface(Typeface.SERIF);
		l1.setBackgroundColor(0xFFFFECB3);
		tex1.setTextColor(0xFFFF5722);
		tex1.setTextSize((int)17.5d);
		tex2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)5, 0xFFFFFFFF));
		tex2.setElevation((float)10);
		tex2.setTextColor(0xFFFF7043);
		tex3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)5, 0xFFFF7043));
		tex3.setElevation((float)10);
		tex3.setTextColor(0xFFFFFFFF);
		tex1.setText("Apakah anda yakin ingin keluar ? ");
		tex2.setText("Tidak");
		tex3.setText("Ya");
		tex2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dialog.dismiss();
			}
		});
		tex3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finishAffinity();
			}
		});
		dialog.show();
	}

	public void _f() {
		final AlertDialog dialog = new AlertDialog.Builder(DownloaderActivity.this).create();
		LayoutInflater inflater = getLayoutInflater();
		View convertView = (View) inflater.inflate(R.layout.ltk, null);
		dialog.setView(convertView);
		final ProgressBar progressBar1 = convertView.findViewById(R.id.progressbar1);
		final TextView textView1 = convertView.findViewById(R.id.textview1);
		final TextView tex2 = convertView.findViewById(R.id.textview2);
		final TextView tex3 = convertView.findViewById(R.id.textview3);
		textView1.setTypeface(Typeface.SERIF);
		tex2.setTypeface(Typeface.SERIF);
		tex3.setTypeface(Typeface.SERIF);
		BroadcastReceiver onProgress = new BroadcastReceiver() {
			        @Override
			        public void onReceive(Context context, Intent intent) {
				            // Perbarui ProgressBar dan TextView saat ada perubahan unduhan
				            DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
				            DownloadManager.Query query = new DownloadManager.Query();
				            query.setFilterById(downloadID);
				            Cursor cursor = dm.query(query);
				            if (cursor.moveToFirst()) {
					                int bytesDownloaded = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
					                int bytesTotal = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));
					                int progress = (int) ((bytesDownloaded * 100L) / bytesTotal);
					                progressBar1.setProgress(progress);
					                textView1.setText(progress + "%");
					            }
				            cursor.close();
				        }
			    };
		    
		    // Daftarkan BroadcastReceiver untuk memperbarui ProgressBar dan TextView saat ada perubahan unduhan
		    registerReceiver(onProgress, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_PROGRESS));
		tex2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
				if (lr) {
					dm.pause(downloadID);
					tex2.setText("Lanjutkan");
					lr = false;
				} else {
					dm.resume(downloadID);
					tex2.setText("Jeda");
					lr = true;
				}
			}
		});
		tex3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
				dm.remove(downloadID);
				ld = false;
				dialog.dismiss();
			}
		});
		dialog.show();
	}
	

	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}

	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}

	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}

	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}

	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}

	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}

	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}

	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}
