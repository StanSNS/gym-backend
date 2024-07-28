package gym.backend.consts.Email.Order;

public class EmailTemplateConst {

    public static final String ORDER_HTML_START = """
            <!DOCTYPE html>
            <html xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office" lang="en">
            <head>
                <title></title>
                <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0"><!--[if mso]><xml><o:OfficeDocumentSettings><o:PixelsPerInch>96</o:PixelsPerInch><o:AllowPNG/></o:OfficeDocumentSettings></xml><![endif]--><!--[if !mso]><!--><!--<![endif]-->
                <style>
                    * {
                        box-sizing: border-box;
                    }

                    body {
                        margin: 0;
                        padding: 0;
                    }

                    a[x-apple-data-detectors] {
                        color: inherit !important;
                        text-decoration: inherit !important;
                    }

                    #MessageViewBody a {
                        color: inherit;
                        text-decoration: none;
                    }
                    p {
                        line-height: inherit
                    }

                    .desktop_hide,
                    .desktop_hide table {
                        mso-hide: all;
                        display: none;
                        max-height: 0px;
                        overflow: hidden;
                    }

                    .image_block img+div {
                        display: none;
                    }

                    @media (max-width:720px) {
                        .desktop_hide table.icons-outer {
                            display: inline-table !important;
                        }

                        .desktop_hide table.icons-inner {
                            display: inline-block !important;
                        }

                        .icons-inner {
                            text-align: center;
                        }
                      
                        .icons-inner td {
                            margin: 0 auto;
                        }
                       
                        .mobile_hide {
                            display: none;
                        }
                    
                        .row-content {
                            width: 100% !important;
                        }
                      
                        .stack .column {
                            width: 100%;
                            display: block;
                        }
                      
                        .mobile_hide {
                            min-height: 0;
                            max-height: 0;
                            max-width: 0;
                            overflow: hidden;
                            font-size: 0px;
                        }
                      
                        .desktop_hide,
                        .desktop_hide table {
                            display: table !important;
                            max-height: none !important;
                        }
                       
                        .row-8 .column-1 .block-1.paragraph_block td.pad>div,
                        .row-8 .column-1 .block-14.paragraph_block td.pad>div {
                            font-size: 30px !important;
                        }
                       
                        .row-6 .column-1 .block-1.heading_block h1 {
                            text-align: center !important;
                        }
                       
                        .row-6 .column-1 .block-1.heading_block h1 {
                            font-size: 27px !important;
                        }
                       
                        .row-8 .column-1 .block-13.divider_block td.pad {
                            padding: 20px !important;
                        }
                       
                        .row-8 .column-1 .block-13.divider_block .alignment table {
                            display: inline-table;
                        }
                       
                        .row-8 .column-1 .block-14.paragraph_block td.pad {
                            padding: 0 10px 10px !important;
                        }
                       
                        .row-16 .column-1 .block-1.icons_block td.pad {
                            padding: 0 15px 0 0 !important;
                        }
                       
                        .row-16 .column-6 .block-1.icons_block td.pad {
                            padding: 0 0 0 10px !important;
                        }
                    }
                </style>
            </head>
            <body style="background-color: #333; margin: 0; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;">
            <table class="nl-container" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #333;">
                <tbody>
                <tr>
                    <td>
            """;

    public static final String ORDER_HTML_END = """
                    </td>
                </tr>
                </tbody>
            </table>
            </body>
            </html>
            """;

    public static final String ORDER_HTML_IMAGE = """
            <table class="row row-1" align="center" width="100%" border="0" cellpadding="0" cellspacing="0"
                   role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                <tbody>
                <tr>
                    <td>
                        <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0"
                               role="presentation"
                               style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-radius: 0; color: #000000; width: 700px; margin: 0 auto;"
                               width="700">
                            <tbody>
                            <tr>
                                <td class="column column-1" width="100%"
                                    style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                    <div class="spacer_block block-1"
                                         style="height:20px;line-height:20px;font-size:1px;">&#8202;
                                    </div>
                                    <table class="image_block block-2" width="100%" border="0" cellpadding="0"
                                           cellspacing="0" role="presentation"
                                           style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                        <tr>
                                            <td class="pad" style="width:100%;">
                                                <div class="alignment" align="center" style="line-height:10px">
                                                    <div style="max-width: 700px;"><img
                                                            src=currentImage
                                                            style="display: block; height: auto; border: 0; width: 100%;"
                                                            width="700" height="auto"></div>
                                                </div>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
                </tbody>
            </table>
            """;

    public static final String ORDER_HTML_INTRO = """
            <table class="row row-2" align="center" width="100%" border="0" cellpadding="0" cellspacing="0"
                               role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            <tbody>
                            <tr>
                                <td>
                                    <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0"
                                           role="presentation"
                                           style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-radius: 0; color: #000000; width: 700px; margin: 0 auto;"
                                           width="700">
                                        <tbody>
                                        <tr>
                                            <td class="column column-1" width="100%"
                                                style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <table class="heading_block block-1" width="100%" border="0" cellpadding="10"
                                                       cellspacing="0" role="presentation"
                                                       style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                    <tr>
                                                        <td class="pad">
                                                            <h1 style="margin: 0; color: #00ff93; direction: ltr; font-family: Arial, Helvetica, sans-serif; font-size: 50px; font-weight: 700; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0; mso-line-height-alt: 72px;">
                                                                <span class="tinyMce-placeholder">GymFit</span></h1>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <table class="row row-3" align="center" width="100%" border="0" cellpadding="0" cellspacing="0"
                               role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            <tbody>
                            <tr>
                                <td>
                                    <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0"
                                           role="presentation"
                                           style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-radius: 0; color: #000000; width: 700px; margin: 0 auto;"
                                           width="700">
                                        <tbody>
                                        <tr>
                                            <td class="column column-1" width="100%"
                                                style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <table class="icons_block block-1" width="100%" border="0" cellpadding="0"
                                                       cellspacing="0" role="presentation"
                                                       style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; text-align: center;">
                                                    <tr>
                                                        <td class="pad"
                                                            style="vertical-align: middle; color: #000000; font-family: inherit; font-size: 14px; font-weight: 400; text-align: center;">
                                                            <table class="icons-outer" cellpadding="0" cellspacing="0"
                                                                   role="presentation"
                                                                   style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-table;">
                                                                <tr>
                                                                    <td style="vertical-align: middle; text-align: center; padding-top: 5px; padding-bottom: 5px; padding-left: 5px; padding-right: 5px;">
                                                                        <img class="icon" src="https://i.imgur.com/L0jlQB0.png"
                                                                             height="auto" width="147" align="center"
                                                                             style="display: block; height: auto; margin: 0 auto; border: 0;">
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <table class="row row-4" align="center" width="100%" border="0" cellpadding="0" cellspacing="0"
                               role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            <tbody>
                            <tr>
                                <td>
                                    <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0"
                                           role="presentation"
                                           style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-radius: 0; color: #000000; width: 700px; margin: 0 auto;"
                                           width="700">
                                        <tbody>
                                        <tr>
                                            <td class="column column-1" width="100%"
                                                style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <table class="heading_block block-1" width="100%" border="0" cellpadding="10"
                                                       cellspacing="0" role="presentation"
                                                       style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                    <tr>
                                                    <tr>
                                                        <td class="pad">
                                                            <h1 style="margin: 0; color: #7747FF; direction: ltr; font-family: Arial, Helvetica, sans-serif; font-size: 24px; font-weight: 700; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0; mso-line-height-alt: 33.6px;">
                                                                <span style="color: #ffffff;"><em>Здравейте,<br><br>introductionOrder<br></em></span><br><span
                                                                    style="color: #ffffff;"><em>Подробностите за вашата поръчка са посочени по-долу: </em></span>
                                                            </h1>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                        </tbody>
            </table>
            """;

    public static final String ORDER_HTML_DIVIDER = """
            <table class="row row-5" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                  <tbody>
                  <tr>
                      <td>
                          <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0"
                                 role="presentation"
                                 style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-radius: 0; color: #000000; width: 700px; margin: 0 auto;"
                                 width="700">
                              <tbody>
                              <tr>
                                  <td class="column column-1" width="100%"
                                      style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                      <table class="divider_block block-1" width="100%" border="0" cellpadding="10"
                                             cellspacing="0" role="presentation"
                                             style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                          <tr>
                                              <td class="pad">
                                                  <div class="alignment" align="center">
                                                      <table border="0" cellpadding="0" cellspacing="0"
                                                             role="presentation" width="100%"
                                                             style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                          <tr>
                                                              <td class="divider_inner"
                                                                  style="font-size: 1px; line-height: 1px; border-top: 2px solid #767676;">
                                                                  <span>&#8202;</span></td>
                                                          </tr>
                                                      </table>
                                                  </div>
                                              </td>
                                          </tr>
                                      </table>
                                  </td>
                              </tr>
                              </tbody>
                          </table>
                      </td>
                  </tr>
                  </tbody>
            </table>
            """;

    public static final String ORDER_HTML_SPACER = """
            <table class="row row-7" align="center" width="100%" border="0" cellpadding="0" cellspacing="0"
                       role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                    <tbody>
                    <tr>
                        <td>
                            <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0"
                                   role="presentation"
                                   style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-radius: 0; color: #000000; width: 700px; margin: 0 auto;"
                                   width="700">
                                <tbody>
                                <tr>
                                    <td class="column column-1" width="100%"
                                        style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                        <div class="spacer_block block-1"
                                             style="height:20px;line-height:20px;font-size:1px;">&#8202;
                                        </div>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    </tbody>
            </table>
            """;


    public static final String ORDER_HTML_RANDOM_ORDER_NUMBER = """
            <table class="row row-6" align="center" width="100%" border="0" cellpadding="0" cellspacing="0"
                   role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                <tbody>
                <tr>
                    <td>
                        <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0"
                               role="presentation"
                               style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #2a2a2a; border-radius: 40px 40px 0 0; color: #000000; width: 700px; margin: 0 auto;"
                               width="700">
                            <tbody>
                            <tr>
                                <td class="column column-1" width="100%"
                                    style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 20px; padding-left: 20px; padding-right: 20px; padding-top: 20px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                    <table class="heading_block block-1" width="100%" border="0" cellpadding="10"
                                           cellspacing="0" role="presentation"
                                           style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                        <tr>
                                            <td class="pad">
                                                <h1 style="margin: 0; color: #ffffff; direction: ltr; font-family: Arial, Helvetica, sans-serif; font-size: 30px; font-weight: 700; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0; mso-line-height-alt: 40.8px;">
                                                    <span class="tinyMce-placeholder">Номер за проследяване на вашата поръчка<br><br><span
                                                            style="color: #00ff93;"><span
                                                            style="color: #ffffff;">№</span>&nbsp; randomGeneratedNumber </span></span>
                                                </h1>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
                </tbody>
            </table>
            """;


    public static final String ORDER_HTML_ALL_INFO = """
            <table class="row row-8" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                <tbody>
                <tr>
                    <td>
                        <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #2a2a2a; border-radius: 0; color: #000000; width: 700px; margin: 0 auto;" width="700">
                            <tbody>
                            <tr>
                                <td class="column column-1" width="100%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 15px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                    <table class="paragraph_block block-1" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                        <tr>
                                            <td class="pad">
                                                <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:36px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:43.199999999999996px;">
                                                    <p style="margin: 0;"><span style="color: #ffffff;"><strong>Информация за адрес</strong></span></p>
                                                </div>
                                            </td>
                                        </tr>
                                    </table>
                                    <table class="table_block block-2" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                        <tr>
                                            <td class="pad" style="padding-left:40px;">
                                                <table style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; width: 100%; table-layout: fixed; direction: ltr; background-color: transparent; font-family: Arial, Helvetica, sans-serif; font-weight: 400; color: #ffffff; text-align: left; letter-spacing: 0px;" width="100%">
                                                    <tbody style="vertical-align: top; font-size: 16px; line-height: 120%;">
                                                    <tr>
                                                        <td width="50%" style="padding: 10px; word-break: break-word; border-top: 0px solid #ff2828; border-right: 0px solid #ff2828; border-bottom: 0px solid #ff2828; border-left: 0px solid #ff2828;"><strong><span style="color: #00ff93;">Име:</span> FirstName<br></strong></td>
                                                        <td width="50%" style="padding: 10px; word-break: break-word; border-top: 0px solid #ff2828; border-right: 0px solid #ff2828; border-bottom: 0px solid #ff2828; border-left: 0px solid #ff2828;"><strong><span style="color: #00ff93;">Фамилия:</span> LastName</strong></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                    <table class="table_block block-3" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                        <tr>
                                            <td class="pad" style="padding-left:40px;">
                                                <table style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; width: 100%; table-layout: fixed; direction: ltr; background-color: transparent; font-family: Arial, Helvetica, sans-serif; font-weight: 400; color: #ffffff; text-align: left; letter-spacing: 0px;" width="100%">
                                                     <tbody style="vertical-align: top; font-size: 16px; line-height: 120%;">
                                         					<tr>
                                         					<td width="50%" style="padding: 10px; word-break: break-word; border-top: 0px solid #ff2828; border-right: 0px solid #ff2828; border-bottom: 0px solid #ff2828; border-left: 0px solid #ff2828;"><strong><span style="color: #00ff93;">Имейл:</span> userEmail</strong></td>
                                         					<td width="50%" style="padding: 10px; word-break: break-word; border-top: 0px solid #ff2828; border-right: 0px solid #ff2828; border-bottom: 0px solid #ff2828; border-left: 0px solid #ff2828;"><strong><span style="color: #00ff93;">Телефон:</span>&nbsp;phoneNumber</strong></td>
                                         				</tr>
                                         			</tbody>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                    <table class="table_block block-4" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                        <tr>
                                            <td class="pad" style="padding-left:40px;padding-top:20px;">
                                                <table style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; width: 100%; table-layout: fixed; direction: ltr; background-color: transparent; font-family: Arial, Helvetica, sans-serif; font-weight: 400; color: #ffffff; text-align: left; letter-spacing: 0px;" width="100%">
                                                    <tbody style="vertical-align: top; font-size: 16px; line-height: 120%;">
                                                    <tr>
                                                        <td width="33.333333333333336%" style="padding: 10px; word-break: break-word; border-top: 0px solid #ff2828; border-right: 0px solid #ff2828; border-bottom: 0px solid #ff2828; border-left: 0px solid #ff2828;"><strong><span style="color: #00ff93;">Държава:</span> Country</strong></td>
                                                        <td width="33.333333333333336%" style="padding: 10px; word-break: break-word; border-top: 0px solid #ff2828; border-right: 0px solid #ff2828; border-bottom: 0px solid #ff2828; border-left: 0px solid #ff2828;"><strong><span style="color: #00ff93;">Град / село: </span>Town</strong></td>
                                                        <td width="33.333333333333336%" style="padding: 10px; word-break: break-word; border-top: 0px solid #ff2828; border-right: 0px solid #ff2828; border-bottom: 0px solid #ff2828; border-left: 0px solid #ff2828;"><strong><span style="color: #00ff93;">ПК:</span> PostCode</strong></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                    <table class="table_block block-5" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                        <tr>
                                            <td class="pad" style="padding-left:40px;">
                                                <table style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; width: 100%; table-layout: fixed; direction: ltr; background-color: transparent; font-family: Arial, Helvetica, sans-serif; font-weight: 400; color: #ffffff; text-align: left; letter-spacing: 0px;" width="100%">
                                                    <tbody style="vertical-align: top; font-size: 16px; line-height: 120%;">
                                                    <tr>
                                                        <td width="50%" style="padding: 10px; word-break: break-word; border-top: 0px solid #ff2828; border-right: 0px solid #ff2828; border-bottom: 0px solid #ff2828; border-left: 0px solid #ff2828;"><strong><span style="color: #00ff93;">Куриерска фирма:</span> Courier</strong></td>
                                                        <td width="50%" style="padding: 10px; word-break: break-word; border-top: 0px solid #ff2828; border-right: 0px solid #ff2828; border-bottom: 0px solid #ff2828; border-left: 0px solid #ff2828;"><strong><span style="color: #00ff93;">Вид на доставка:</span> deliveryType</strong></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                    <table class="table_block block-6" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                        <tr>
                                            <td class="pad" style="padding-left:40px;">
                                                <table style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; width: 100%; table-layout: fixed; direction: ltr; background-color: transparent; font-family: Arial, Helvetica, sans-serif; font-weight: 400; color: #ffffff; text-align: left; letter-spacing: 0px;" width="100%">
                                                    <tbody style="vertical-align: top; font-size: 16px; line-height: 120%;">
                                                    <tr>
                                                        <td width="100%" style="padding: 10px; word-break: break-word; border-top: 0px solid #ff2828; border-right: 0px solid #ff2828; border-bottom: 0px solid #ff2828; border-left: 0px solid #ff2828;"><strong><span style="color: #00ff93;">Адрес:</span> addressLineOne</strong></td>
                                                        speedyTrackingNumberField
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                    <table class="divider_block block-8" width="100%" border="0" cellpadding="20" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                        <tr>
                                            <td class="pad">
                                                <div class="alignment" align="center">
                                                    <table border="0" cellpadding="0" cellspacing="0" role="presentation" width="70%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                        <tr>
                                                            <td class="divider_inner" style="font-size: 1px; line-height: 1px; border-top: 2px solid #767676;"><span>&#8202;</span></td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </td>
                                        </tr>
                                    </table>
                                    <table class="paragraph_block block-9" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                        <tr>
                                            <td class="pad" style="padding-bottom:10px;padding-left:10px;padding-right:10px;">
                                                <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:34px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:40.8px;">
                                                    <p style="margin: 0;"><span style="color: #ffffff;"><strong>Информация за поръчка</strong></span></p>
                                                </div>
                                            </td>
                                        </tr>
                                    </table>
                                    <table class="table_block block-10" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                        <tr>
                                            <td class="pad" style="padding-left:40px;">
                                                <table style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; width: 100%; table-layout: fixed; direction: ltr; background-color: transparent; font-family: Arial, Helvetica, sans-serif; font-weight: 400; color: #ffffff; text-align: center; letter-spacing: 0px;" width="100%">
                                                    <tbody style="vertical-align: top; font-size: 16px; line-height: 120%;">
                                                    <tr>
                                                        <td width="33.333333333333336%" style="padding: 10px; word-break: break-word; border-top: 0px solid #ff2828; border-right: 0px solid #ff2828; border-bottom: 0px solid #ff2828; border-left: 0px solid #ff2828;"><strong><span style="color: #00ff93;">Общо продукти:</span> totalProductCount бр</strong></td>
                                                        <td width="33.333333333333336%" style="padding: 10px; word-break: break-word; border-top: 0px solid #ff2828; border-right: 0px solid #ff2828; border-bottom: 0px solid #ff2828; border-left: 0px solid #ff2828;"><strong><span style="color: #00ff93;">Тегло:</span> totalWeight кг.</strong></td>
                                                        <td width="33.333333333333336%" style="padding: 10px; word-break: break-word; border-top: 0px solid #ff2828; border-right: 0px solid #ff2828; border-bottom: 0px solid #ff2828; border-left: 0px solid #ff2828;"><strong><span style="color: #00ff93;">Доставка:</span>&nbsp;deliveryPrice лв.</strong></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                    <table class="table_block block-11" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                        <tr>
                                            <td class="pad" style="padding-left:40px;">
                                                <table style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; width: 100%; table-layout: fixed; direction: ltr; background-color: transparent; font-family: Arial, Helvetica, sans-serif; font-weight: 400; color: #ffffff; text-align: center; letter-spacing: 0px;" width="100%">
                                                    <tbody style="vertical-align: top; font-size: 16px; line-height: 120%;">
                                                    <tr>
                                                        <td width="100%" style="padding: 10px; word-break: break-word; border-top: 0px solid #ff2828; border-right: 0px solid #ff2828; border-bottom: 0px solid #ff2828; border-left: 0px solid #ff2828;"><strong><span style="color: #00ff93;">Спестихте общо:</span> totalSaved лв.</strong></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                    <table class="table_block block-11" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                        <tr>
                                            <td class="pad" style="padding-left:40px;">
                                                <table style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; width: 100%; table-layout: fixed; direction: ltr; background-color: transparent; font-family: Arial, Helvetica, sans-serif; font-weight: 400; color: #ffffff; text-align: center; letter-spacing: 0px;" width="100%">
                                                    <tbody style="vertical-align: top; font-size: 16px; line-height: 120%;">
                                                    <tr>
                                                        <td width="100%" style="padding: 10px; word-break: break-word; border-top: 0px solid #ff2828; border-right: 0px solid #ff2828; border-bottom: 0px solid #ff2828; border-left: 0px solid #ff2828;"><strong><span style="color: #00ff93;">Дължима сума при доставка:</span> totalAmount лв.</strong></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
                </tbody>
            </table>
            """;

    public static final String ORDER_HTML_PRODUCT = """
            <table class="row row-7" align="center" width="100%" border="0" cellpadding="0" cellspacing="0"
                       role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                    <tbody>
                    <tr>
                        <td>
                            <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0"
                                   role="presentation"
                                   style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-radius: 0; color: #000000; width: 700px; margin: 0 auto;"
                                   width="700">
                                <tbody>
                                <tr>
                                    <td class="column column-1" width="100%"
                                        style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                        <div class="spacer_block block-1"
                                             style="height:20px;line-height:20px;font-size:1px;">&#8202;
                                        </div>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    </tbody>
            </table>
            <table class="row row-10" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                          <tbody>
                          <tr>
                              <td>
                                  <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; border-radius: 30px; color: #000000; width: 700px; margin: 0 auto;" width="700">
                                      <tbody>
                                      <tr>
                                          <td class="column column-1" width="33.333333333333336%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: middle; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                              <table class="image_block block-1" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                  <tr>
                                                      <td class="pad" style="width:100%;padding-right:0px;padding-left:0px;">
                                                          <div class="alignment" align="center" style="line-height:10px">
                                                              <div style="max-width: 163.333px;"><img src="productImage" style="display: block; height: auto; border: 0; width: 100%;" width="163.333" alt="I'm an image" title="I'm an image" height="auto"></div>
                                                          </div>
                                                      </td>
                                                  </tr>
                                              </table>
                                          </td>
                                          <td class="column column-2" width="66.66666666666667%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: middle; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                              <table class="table_block block-1" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                  <tr>
                                                      <td class="pad" style="padding-right:30px;padding-top:5px;">
                                                          <table style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; width: 100%; table-layout: fixed; direction: ltr; background-color: #2a2a2a; font-family: Arial, Helvetica, sans-serif; font-weight: 700; color: #ffffff; text-align: center; letter-spacing: 0px;" width="100%">
                                                              <tbody style="vertical-align: top; font-size: 16px; line-height: 120%;">
                                                              <tr>
                                                                  <td width="100%" style="padding: 10px; word-break: break-word; border-top: 0px dotted #ff2828; border-right: 0px dotted #ff2828; border-bottom: 0px dotted #ff2828; border-left: 0px dotted #ff2828;"><strong><em>productTitle</em></strong></td>
                                                              </tr>
                                                              </tbody>
                                                          </table>
                                                      </td>
                                                  </tr>
                                              </table>
                                              <table class="table_block block-2" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                  <tr>
                                                      <td class="pad" style="padding-right:30px;">
                                                          <table style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; width: 100%; table-layout: fixed; direction: ltr; background-color: #2a2a2a; font-family: Arial, Helvetica, sans-serif; font-weight: 400; color: #ffffff; text-align: center; letter-spacing: 0px;" width="100%">
                                                              <tbody style="vertical-align: top; font-size: 16px; line-height: 120%;">
                                                              <tr>
                                                                  <td width="33.333333333333336%" style="padding: 10px; word-break: break-word; border-top: 0px dotted #ff2828; border-right: 0px dotted #ff2828; border-bottom: 0px dotted #ff2828; border-left: 0px dotted #ff2828;"><strong><span style="color: #00ff93;">Тегло:</span><br></strong></td>
                                                                  <td width="33.333333333333336%" style="padding: 10px; word-break: break-word; border-top: 0px dotted #ff2828; border-right: 0px dotted #ff2828; border-bottom: 0px dotted #ff2828; border-left: 0px dotted #ff2828;"><strong><span style="color: #00ff93;">Вкус:</span></strong></td>
                                                                  <td width="33.333333333333336%" style="padding: 10px; word-break: break-word; border-top: 0px dotted #ff2828; border-right: 0px dotted #ff2828; border-bottom: 0px dotted #ff2828; border-left: 0px dotted #ff2828;"><span class="tinyMce-placeholder" style="color: #00ff93;"><strong>Брой:</strong></span></td>
                                                              </tr>
                                                              <tr>
                                                                  <td width="33.333333333333336%" style="padding: 10px; word-break: break-word; border-top: 0px dotted #ff2828; border-right: 0px dotted #ff2828; border-bottom: 0px dotted #ff2828; border-left: 0px dotted #ff2828;"><strong>productWeight кг.</strong></td>
                                                                  <td width="33.333333333333336%" style="padding: 10px; word-break: break-word; border-top: 0px dotted #ff2828; border-right: 0px dotted #ff2828; border-bottom: 0px dotted #ff2828; border-left: 0px dotted #ff2828;"><strong>productTaste &nbsp;</strong></td>
                                                                  <td width="33.333333333333336%" style="padding: 10px; word-break: break-word; border-top: 0px dotted #ff2828; border-right: 0px dotted #ff2828; border-bottom: 0px dotted #ff2828; border-left: 0px dotted #ff2828;"><strong>xproductQuantity &nbsp;</strong></td>
                                                              </tr>
                                                              </tbody>
                                                          </table>
                                                      </td>
                                                  </tr>
                                              </table>
                                              <table class="table_block block-3" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                  <tr>
                                                      <td class="pad" style="padding-bottom:5px;padding-right:30px;">
                                                          <table style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse; width: 100%; table-layout: fixed; direction: ltr; background-color: #2a2a2a; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; font-weight: 700; color: #ffffff; text-align: center; letter-spacing: 0px;" width="100%">
                                                              <tbody style="vertical-align: top; font-size: 16px; line-height: 120%;">
                                                              <tr>
                                                                  <td width="33.333333333333336%" style="padding: 10px; word-break: break-word; border-top: 0px dotted #ff2828; border-right: 0px dotted #ff2828; border-bottom: 0px dotted #ff2828; border-left: 0px dotted #ff2828;"><strong><span style="text-decoration: line-through;"><span style="color: #00ff93; text-decoration: line-through;">Редовна:</span></span><br></strong></td>
                                                                  <td width="33.333333333333336%" style="padding: 10px; word-break: break-word; border-top: 0px dotted #ff2828; border-right: 0px dotted #ff2828; border-bottom: 0px dotted #ff2828; border-left: 0px dotted #ff2828;"><span class="tinyMce-placeholder" style="color: #00ff93;"><strong>Намалена:</strong></span></td>
                                                                  <td width="33.333333333333336%" style="padding: 10px; word-break: break-word; border-top: 0px dotted #ff2828; border-right: 0px dotted #ff2828; border-bottom: 0px dotted #ff2828; border-left: 0px dotted #ff2828;"><span class="tinyMce-placeholder" style="color: #00ff93;">Спестявате:</span></td>
                                                              </tr>
                                                              <tr>
                                                                  <td width="33.333333333333336%" style="padding: 10px; word-break: break-word; border-top: 0px dotted #ff2828; border-right: 0px dotted #ff2828; border-bottom: 0px dotted #ff2828; border-left: 0px dotted #ff2828;"><strong> regularPrice лв.</strong></td>
                                                                  <td width="33.333333333333336%" style="padding: 10px; word-break: break-word; border-top: 0px dotted #ff2828; border-right: 0px dotted #ff2828; border-bottom: 0px dotted #ff2828; border-left: 0px dotted #ff2828;"><strong>reducedPrice лв.</strong></td>
                                                                  <td width="33.333333333333336%" style="padding: 10px; word-break: break-word; border-top: 0px dotted #ff2828; border-right: 0px dotted #ff2828; border-bottom: 0px dotted #ff2828; border-left: 0px dotted #ff2828;">savedAmount лв.</td>
                                                              </tr>
                                                              </tbody>
                                                          </table>
                                                      </td>
                                                  </tr>
                                              </table>
                                          </td>
                                      </tr>
                                      </tbody>
                                  </table>
                              </td>
                          </tr>
                          </tbody>
                      </table>
            """;


    public static final String ORDER_HTML_DISCLAIMER_INFO = """
            <table class="row row-12" align="center" width="100%" border="0" cellpadding="0" cellspacing="0"
                               role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            <tbody>
                            <tr>
                                <td>
                                    <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0"
                                           role="presentation"
                                           style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-radius: 0; color: #000000; width: 700px; margin: 0 auto;"
                                           width="700">
                                        <tbody>
                                        <tr>
                                            <td class="column column-1" width="100%"
                                                style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <table class="heading_block block-1" width="100%" border="0" cellpadding="10"
                                                       cellspacing="0" role="presentation"
                                                       style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                    <tr>
                                                        <td class="pad">
                                                            <h1 style="margin: 0; color: #7747FF; direction: ltr; font-family: Arial, Helvetica, sans-serif; font-size: 22px; font-weight: 700; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0; mso-line-height-alt: 31.2px;">
                                                                <span style="color: #ffffff;"><em><strong>disclaimerOne<br><br></strong></em><em><strong>disclaimerTwo</strong></em></span>
                                                            </h1>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                                 <table class="row row-5" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                  <tbody>
                  <tr>
                      <td>
                          <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0"
                                 role="presentation"
                                 style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-radius: 0; color: #000000; width: 700px; margin: 0 auto;"
                                 width="700">
                              <tbody>
                              <tr>
                                  <td class="column column-1" width="100%"
                                      style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                      <table class="divider_block block-1" width="100%" border="0" cellpadding="10"
                                             cellspacing="0" role="presentation"
                                             style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                          <tr>
                                              <td class="pad">
                                                  <div class="alignment" align="center">
                                                      <table border="0" cellpadding="0" cellspacing="0"
                                                             role="presentation" width="100%"
                                                             style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                          <tr>
                                                              <td class="divider_inner"
                                                                  style="font-size: 1px; line-height: 1px; border-top: 2px solid #767676;">
                                                                  <span>&#8202;</span></td>
                                                          </tr>
                                                      </table>
                                                  </div>
                                              </td>
                                          </tr>
                                      </table>
                                  </td>
                              </tr>
                              </tbody>
                          </table>
                      </td>
                  </tr>
                  </tbody>
            </table>
                        <table class="row row-14" align="center" width="100%" border="0" cellpadding="0" cellspacing="0"
                               role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            <tbody>
                            <tr>
                                <td>
                                    <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0"
                                           role="presentation"
                                           style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #2a2a2a; border-radius: 0; color: #000000; width: 700px; margin: 0 auto;"
                                           width="700">
                                        <tbody>
                                        <tr>
                                            <td class="column column-1" width="100%"
                                                style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 15px; padding-top: 15px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <table class="icons_block block-1" width="100%" border="0" cellpadding="0"
                                                       cellspacing="0" role="presentation"
                                                       style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; text-align: center;">
                                                    <tr>
                                                        <td class="pad"
                                                            style="vertical-align: middle; color: #000000; font-family: inherit; font-size: 14px; font-weight: 400; text-align: center;">
                                                            <table class="icons-outer" cellpadding="0" cellspacing="0"
                                                                   role="presentation"
                                                                   style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-table;">
                                                                <tr>
                                                                    <td style="vertical-align: middle; text-align: center; padding-top: 5px; padding-bottom: 5px; padding-left: 5px; padding-right: 5px;">
                                                                        <img class="icon" src="https://i.imgur.com/L0jlQB0.png"
                                                                             height="auto" width="147" align="center"
                                                                             style="display: block; height: auto; margin: 0 auto; border: 0;">
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-2" width="100%" border="0" cellpadding="10"
                                                       cellspacing="0" role="presentation"
                                                       style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:32px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:43.199999999999996px;">
                                                                <p style="margin: 0;"><span style="color: #ffffff;"><strong>Нуждаете се от помощ ?</strong></span>
                                                                </p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-3" width="100%" border="0" cellpadding="10"
                                                       cellspacing="0" role="presentation"
                                                       style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:18px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:24px;">
                                                                <p style="margin: 0;"><span style="color: #ffffff;"><strong>Тук сме да помогнем !</strong></span>
                                                                </p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-4" width="100%" border="0" cellpadding="10"
                                                       cellspacing="0" role="presentation"
                                                       style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:18px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:24px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ffffff;">Нашите екипи са на разположение <br>Понеделник - Петък<br>(от 9:00 до 17:00 часа)</span></strong>
                                                                </p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="button_block block-5" width="100%" border="0" cellpadding="10"
                                                       cellspacing="0" role="presentation"
                                                       style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div class="alignment" align="center"><!--[if mso]>
                                                                <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml"
                                                                             xmlns:w="urn:schemas-microsoft-com:office:word"
                                                                             href="#"
                                                                             style="height:38px;width:170px;v-text-anchor:middle;"
                                                                             arcsize="27%" stroke="false" fillcolor="#00ff93">
                                                                    <w:anchorlock/>
                                                                    <v:textbox inset="0px,0px,0px,0px">
                                                                        <center style="color:#ffffff; font-family:Arial, sans-serif; font-size:16px">
                                                                <![endif]--><a
                                                                        href="#"
                                                                        target="_blank"
                                                                        style="text-decoration:none;display:inline-block;color:#333333;background-color:#00ff93;border-radius:10px;width:auto;border-top:0px solid transparent;font-weight:400;border-right:0px solid transparent;border-bottom:0px solid transparent;border-left:0px solid transparent;padding-top:5px;padding-bottom:5px;font-family:Arial, Helvetica, sans-serif;font-size:16px;text-align:center;mso-border-alt:none;word-break:keep-all;"><span
                                                                        style="padding-left:20px;padding-right:20px;font-size:16px;display:inline-block;letter-spacing:normal;"><span
                                                                        style="word-break: break-word; line-height: 28.8px;"><strong>Свържи се с нас</strong></span></span></a>
                                                                <!--[if mso]></center></v:textbox></v:roundrect><![endif]--></div>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
            """;


    public static final String ORDER_HTML_FOOTER = """
             <table class="row row-16" align="center" width="100%" border="0" cellpadding="0" cellspacing="0"
                               role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            <tbody>
                            <tr>
                                <td>
                                    <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0"
                                           role="presentation"
                                           style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #2a2a2a; border-radius: 0 0 30px 30px; color: #000000; width: 700px; margin: 0 auto;"
                                           width="700">
                                        <tbody>
                                        <tr>
                                            <td class="column column-1" width="16.666666666666668%"
                                                style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 25px; padding-left: 20px; padding-right: 10px; padding-top: 25px; vertical-align: middle; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <table class="icons_block block-1" width="100%" border="0" cellpadding="0"
                                                       cellspacing="0" role="presentation"
                                                       style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; text-align: center;">
                                                    <tr>
                                                        <td class="pad"
                                                            style="vertical-align: middle; color: #ffffff; font-family: inherit; font-size: 14px; font-weight: 700; text-align: center;">
                                                            <table width="100%" cellpadding="0" cellspacing="0" role="presentation"
                                                                   style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                                <tr>
                                                                    <td class="alignment"
                                                                        style="vertical-align: middle; text-align: center;">
                                                                        <!--[if vml]>
                                                                        <table align="center" cellpadding="0" cellspacing="0"
                                                                               role="presentation"
                                                                               style="display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;">
                                                                        <![endif]-->
                                                                        <!--[if !vml]><!-->
                                                                        <table class="icons-inner"
                                                                               style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block; margin-right: -4px; padding-left: 0px; padding-right: 0px;"
                                                                               cellpadding="0" cellspacing="0" role="presentation">
                                                                            <!--<![endif]-->
                                                                            <tr>
                                                                                <td style="vertical-align: middle; text-align: center; padding-top: 15px; padding-bottom: 15px; padding-left: 15px; padding-right: 15px;">
                                                                                    <a href="#"
                                                                                       target="_blank"
                                                                                       style="text-decoration: none;"><img
                                                                                            class="icon" alt="Facebook"
                                                                                            src="https://static.vecteezy.com/system/resources/previews/023/986/613/non_2x/facebook-logo-facebook-logo-transparent-facebook-icon-transparent-free-free-png.png"
                                                                                            height="auto" width="32" align="center"
                                                                                            style="display: block; height: auto; margin: 0 auto; border: 0;"></a>
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td style="font-family: Arial, Helvetica, sans-serif; font-size: 14px; font-weight: 700; color: #ffffff; vertical-align: middle; letter-spacing: undefined; text-align: center;">
                                                                                    <a href="#"
                                                                                       target="_blank"
                                                                                       style="color: #ffffff; text-decoration: none;">Facebook</a>
                                                                                </td>
                                                                            </tr>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td class="column column-2" width="16.666666666666668%"
                                                style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-left: 5px; padding-right: 10px; padding-top: 5px; vertical-align: middle; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <table class="icons_block block-1" width="100%" border="0" cellpadding="0"
                                                       cellspacing="0" role="presentation"
                                                       style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; text-align: center;">
                                                    <tr>
                                                        <td class="pad"
                                                            style="vertical-align: middle; color: #ffffff; font-family: inherit; font-size: 14px; font-weight: 700; text-align: center;">
                                                            <table width="100%" cellpadding="0" cellspacing="0" role="presentation"
                                                                   style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                                <tr>
                                                                    <td class="alignment"
                                                                        style="vertical-align: middle; text-align: center;">
                                                                        <!--[if vml]>
                                                                        <table align="center" cellpadding="0" cellspacing="0"
                                                                               role="presentation"
                                                                               style="display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;">
                                                                        <![endif]-->
                                                                        <!--[if !vml]><!-->
                                                                        <table class="icons-inner"
                                                                               style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block; margin-right: -4px; padding-left: 0px; padding-right: 0px;"
                                                                               cellpadding="0" cellspacing="0" role="presentation">
                                                                            <!--<![endif]-->
                                                                            <tr>
                                                                                <td style="vertical-align: middle; text-align: center; padding-top: 15px; padding-bottom: 15px; padding-left: 15px; padding-right: 15px;">
                                                                                    <a href="#"
                                                                                       target="_blank"
                                                                                       style="text-decoration: none;"><img
                                                                                            class="icon" alt="Instagram"
                                                                                            src="https://www.pngall.com/wp-content/uploads/5/Instagram-Logo-PNG-Image.png"
                                                                                            height="auto" width="32" align="center"
                                                                                            style="display: block; height: auto; margin: 0 auto; border: 0;"></a>
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td style="font-family: Arial, Helvetica, sans-serif; font-size: 14px; font-weight: 700; color: #ffffff; vertical-align: middle; letter-spacing: undefined; text-align: center;">
                                                                                    <a href="#"
                                                                                       target="_blank"
                                                                                       style="color: #ffffff; text-decoration: none;">Instagram</a>
                                                                                </td>
                                                                            </tr>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td class="column column-3" width="16.666666666666668%"
                                                style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-left: 5px; padding-right: 10px; padding-top: 5px; vertical-align: middle; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <table class="icons_block block-1" width="100%" border="0" cellpadding="0"
                                                       cellspacing="0" role="presentation"
                                                       style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; text-align: center;">
                                                    <tr>
                                                        <td class="pad"
                                                            style="vertical-align: middle; color: #ffffff; font-family: inherit; font-size: 14px; font-weight: 700; text-align: center;">
                                                            <table width="100%" cellpadding="0" cellspacing="0" role="presentation"
                                                                   style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                                <tr>
                                                                    <td class="alignment"
                                                                        style="vertical-align: middle; text-align: center;">
                                                                        <!--[if vml]>
                                                                        <table align="center" cellpadding="0" cellspacing="0"
                                                                               role="presentation"
                                                                               style="display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;">
                                                                        <![endif]-->
                                                                        <!--[if !vml]><!-->
                                                                        <table class="icons-inner"
                                                                               style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block; margin-right: -4px; padding-left: 0px; padding-right: 0px;"
                                                                               cellpadding="0" cellspacing="0" role="presentation">
                                                                            <!--<![endif]-->
                                                                            <tr>
                                                                                <td style="vertical-align: middle; text-align: center; padding-top: 15px; padding-bottom: 15px; padding-left: 15px; padding-right: 15px;">
                                                                                    <a href="#"
                                                                                       target="_blank"
                                                                                       style="text-decoration: none;"><img
                                                                                            class="icon" alt="tik tok"
                                                                                            src="https://iconape.com/wp-content/files/fd/121669/svg/tiktok-logo-tik-tok-logo-icon-png-svg.png"
                                                                                            height="auto" width="28" align="center"
                                                                                            style="display: block; height: auto; margin: 0 auto; border: 0;"></a>
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td style="font-family: Arial, Helvetica, sans-serif; font-size: 14px; font-weight: 700; color: #ffffff; vertical-align: middle; letter-spacing: undefined; text-align: center;">
                                                                                    <a href="#"
                                                                                       target="_blank"
                                                                                       style="color: #ffffff; text-decoration: none;">Tik
                                                                                        Tok</a></td>
                                                                            </tr>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td class="column column-4" width="16.666666666666668%"
                                                style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-left: 5px; padding-right: 10px; padding-top: 5px; vertical-align: middle; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <table class="icons_block block-1" width="100%" border="0" cellpadding="0"
                                                       cellspacing="0" role="presentation"
                                                       style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; text-align: center;">
                                                    <tr>
                                                        <td class="pad"
                                                            style="vertical-align: middle; color: #ffffff; font-family: inherit; font-size: 14px; font-weight: 700; text-align: center;">
                                                            <table width="100%" cellpadding="0" cellspacing="0" role="presentation"
                                                                   style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                                <tr>
                                                                    <td class="alignment"
                                                                        style="vertical-align: middle; text-align: center;">
                                                                        <!--[if vml]>
                                                                        <table align="center" cellpadding="0" cellspacing="0"
                                                                               role="presentation"
                                                                               style="display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;">
                                                                        <![endif]-->
                                                                        <!--[if !vml]><!-->
                                                                        <table class="icons-inner"
                                                                               style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block; margin-right: -4px; padding-left: 0px; padding-right: 0px;"
                                                                               cellpadding="0" cellspacing="0" role="presentation">
                                                                            <!--<![endif]-->
                                                                            <tr>
                                                                                <td style="vertical-align: middle; text-align: center; padding-top: 15px; padding-bottom: 15px; padding-left: 15px; padding-right: 15px;">
                                                                                    <a href="#"
                                                                                       target="_blank"
                                                                                       style="text-decoration: none;"><img
                                                                                            class="icon" alt="Twitter(X)"
                                                                                            src="https://freelogopng.com/images/all_img/1690643591twitter-x-logo-png.png"
                                                                                            height="auto" width="32" align="center"
                                                                                            style="display: block; height: auto; margin: 0 auto; border: 0;"></a>
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td style="font-family: Arial, Helvetica, sans-serif; font-size: 14px; font-weight: 700; color: #ffffff; vertical-align: middle; letter-spacing: undefined; text-align: center;">
                                                                                    <a href="#"
                                                                                       target="_blank"
                                                                                       style="color: #ffffff; text-decoration: none;">Twitter(X)</a>
                                                                                </td>
                                                                            </tr>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td class="column column-5" width="16.666666666666668%"
                                                style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-left: 5px; padding-right: 10px; padding-top: 5px; vertical-align: middle; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <table class="icons_block block-1" width="100%" border="0" cellpadding="0"
                                                       cellspacing="0" role="presentation"
                                                       style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; text-align: center;">
                                                    <tr>
                                                        <td class="pad"
                                                            style="vertical-align: middle; color: #ffffff; font-family: inherit; font-size: 14px; font-weight: 700; text-align: center;">
                                                            <table width="100%" cellpadding="0" cellspacing="0" role="presentation"
                                                                   style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                                <tr>
                                                                    <td class="alignment"
                                                                        style="vertical-align: middle; text-align: center;">
                                                                        <!--[if vml]>
                                                                        <table align="center" cellpadding="0" cellspacing="0"
                                                                               role="presentation"
                                                                               style="display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;">
                                                                        <![endif]-->
                                                                        <!--[if !vml]><!-->
                                                                        <table class="icons-inner"
                                                                               style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block; margin-right: -4px; padding-left: 0px; padding-right: 0px;"
                                                                               cellpadding="0" cellspacing="0" role="presentation">
                                                                            <!--<![endif]-->
                                                                            <tr>
                                                                                <td style="vertical-align: middle; text-align: center; padding-top: 15px; padding-bottom: 15px; padding-left: 15px; padding-right: 15px;">
                                                                                    <a href="mailto:Sendto...?subject=Subject...&body=Body..."
                                                                                       target="_blank"
                                                                                       style="text-decoration: none;"><img
                                                                                            class="icon" alt="G-mail"
                                                                                            src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Gmail_icon_%282020%29.svg/2560px-Gmail_icon_%282020%29.svg.png"
                                                                                            height="auto" width="43" align="center"
                                                                                            style="display: block; height: auto; margin: 0 auto; border: 0;"></a>
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td style="font-family: Arial, Helvetica, sans-serif; font-size: 14px; font-weight: 700; color: #ffffff; vertical-align: middle; letter-spacing: undefined; text-align: center;">
                                                                                    <a href="mailto:Sendto...?subject=Subject...&body=Body..."
                                                                                       target="_blank"
                                                                                       style="color: #ffffff; text-decoration: none;">G-mail</a>
                                                                                </td>
                                                                            </tr>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td class="column column-6" width="16.666666666666668%"
                                                style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-left: 5px; padding-right: 20px; padding-top: 5px; vertical-align: middle; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <table class="icons_block block-1" width="100%" border="0" cellpadding="0"
                                                       cellspacing="0" role="presentation"
                                                       style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; text-align: center;">
                                                    <tr>
                                                        <td class="pad"
                                                            style="vertical-align: middle; color: #ffffff; font-family: inherit; font-size: 14px; font-weight: 700; text-align: center;">
                                                            <table width="100%" cellpadding="0" cellspacing="0" role="presentation"
                                                                   style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                                <tr>
                                                                    <td class="alignment"
                                                                        style="vertical-align: middle; text-align: center;">
                                                                        <!--[if vml]>
                                                                        <table align="center" cellpadding="0" cellspacing="0"
                                                                               role="presentation"
                                                                               style="display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;">
                                                                        <![endif]-->
                                                                        <!--[if !vml]><!-->
                                                                        <table class="icons-inner"
                                                                               style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block; margin-right: -4px; padding-left: 0px; padding-right: 0px;"
                                                                               cellpadding="0" cellspacing="0" role="presentation">
                                                                            <!--<![endif]-->
                                                                            <tr>
                                                                                <td style="vertical-align: middle; text-align: center; padding-top: 15px; padding-bottom: 15px; padding-left: 15px; padding-right: 15px;">
                                                                                    <a href="tel:0888888888" target="_blank"
                                                                                       style="text-decoration: none;"><img
                                                                                            class="icon" alt="Whatsapp"
                                                                                            src="https://upload.wikimedia.org/wikipedia/commons/5/5e/WhatsApp_icon.png"
                                                                                            height="auto" width="32" align="center"
                                                                                            style="display: block; height: auto; margin: 0 auto; border: 0;"></a>
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td style="font-family: Arial, Helvetica, sans-serif; font-size: 14px; font-weight: 700; color: #ffffff; vertical-align: middle; letter-spacing: undefined; text-align: center;">
                                                                                    <a href="tel:0888888888" target="_blank"
                                                                                       style="color: #ffffff; text-decoration: none;">Whatsapp</a>
                                                                                </td>
                                                                            </tr>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <table class="row row-17" align="center" width="100%" border="0" cellpadding="0" cellspacing="0"
                               role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            <tbody>
                            <tr>
                                <td>
                                    <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0"
                                           role="presentation"
                                           style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 700px; margin: 0 auto;"
                                           width="700">
                                        <tbody>
                                        <tr>
                                            <td class="column column-1" width="100%"
                                                style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <table class="heading_block block-1" width="100%" border="0" cellpadding="10"
                                                       cellspacing="0" role="presentation"
                                                       style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                    <tr>
                                                        <td class="pad">
                                                            <h3 style="margin: 0; color: #6c6c6c; direction: ltr; font-family: Arial, Helvetica, sans-serif; font-size: 12px; font-weight: 700; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0; mso-line-height-alt: 16.8px;">
                                                                <span class="tinyMce-placeholder">Този имейл е изпратен от example@abv.bg и е само информативен имейл. Това не означава, че сте се абонирали за маркетинг от страна на GymFit.<br><br>GymFit е дружество с ограничена отговорност, регистрирано в България.</span>
                                                            </h3>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <div class="spacer_block block-2"
                                                     style="height:20px;line-height:20px;font-size:1px;">&#8202;
                                                </div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
            </table>
            """;


}