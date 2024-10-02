import React, { memo } from "react";
import { Page } from "react-onsenui";
import { useMediaQuery } from "@material-ui/core";
import { Row, Col, Image } from "antd";
import styles from "./TripPage.module.scss";
import { TripViewModel } from "../viewmodels/TripViewModel";
import { useLocation, useNavigate } from "react-router-dom";
import TagView from "./TagView";
import Search from "antd/es/input/Search";
import { TagViewModel } from "../viewmodels/TagViewModel";
import DetailView from "./DetailView";

function TripPage() {
  const isXS = useMediaQuery("(max-width: 576px)");
  const location = useLocation();
  const navigate = useNavigate();
  const query = new URLSearchParams(location.search);
  let keyword = query.get("keyword");
  if (keyword == null) {
    keyword = "";
  }
  const { trips, loadingTrip } = TripViewModel(keyword);
  const { tags, loadingTag } = TagViewModel();

  const navigateToTrips = (value) => {
    navigate("/trips?keyword=" + value);
  };

  const onSearch = (value) => {
    navigateToTrips(value);
  };

  return (
    <Page>
      <div className={styles.ResponsiveContent}>
        <div
          style={{
            display: "flex",
            justifyContent: "center",
            margin: "36px 0  18px 0",
          }}
        >
          <Search
            style={{
              padding: isXS ? "0 36px 0 36px" : "0 0 0 0",
              maxWidth: "576px",
            }}
            placeholder="ค้นหาหมวด"
            allowClear
            enterButton="ค้นหา"
            size="large"
            onSearch={onSearch}
          />
        </div>
        <div style={{ display: "flex", justifyContent: "center" }}>
          <div
            style={{
              maxWidth: "576px",
              padding: isXS ? "0 36px 36px 36px" : "0 0 36px 0",
            }}
          >
            <div
              style={{
                color: "grey",
              }}
            >
              หมวดยอดนิยม
              <TagView tags={tags} />
            </div>
          </div>
        </div>
        <Row gutter={[36, 36]}>
          {trips?.map((item, idx) => {
            const tags = item.tags;
            return (
              <Col key={idx} xs={24} sm={12}>
                {isXS ? (
                  <Col key={idx} xs={24} sm={12}>
                    <Col style={{ paddingBottom: 12 }}>
                      <Image
                        width={"100%"}
                        src={item.photos[0]}
                        alt="Not found image"
                        preview={false}
                        style={{ objectFit: "cover", borderRadius: 20 }}
                      />
                    </Col>
                    <Col
                      style={{
                        display: "flex",
                        flexDirection: "column",
                        flex: 1,
                      }}
                    >
                      <div
                        style={{
                          flex: 1,
                        }}
                      >
                        <DetailView
                          title={item.title}
                          description={item.description}
                          tags={tags}
                        />
                      </div>
                    </Col>
                  </Col>
                ) : (
                  <Row>
                    <Col>
                      <Image
                        width={120}
                        height={215}
                        src={item.photos[0]}
                        alt="Not found image"
                        preview={false}
                        style={{ objectFit: "cover", borderRadius: 20 }}
                      />
                    </Col>
                    <Col
                      style={{
                        display: "flex",
                        flexDirection: "column",
                        flex: 1,
                      }}
                    >
                      <div
                        style={{
                          flex: 1,
                          paddingLeft: 16,
                        }}
                      >
                        <DetailView
                          title={item.title}
                          description={item.description}
                          tags={tags}
                        />
                      </div>
                      <Row>
                        <Col flex={1}>
                          <div
                            className={styles.ImageSmall}
                            style={{
                              backgroundImage: `url(${item.photos[1]})`,
                            }}
                          ></div>
                        </Col>
                        <Col flex={1}>
                          <div
                            className={styles.ImageSmall}
                            style={{
                              backgroundImage: `url(${item.photos[2]})`,
                            }}
                          ></div>
                        </Col>
                        <Col flex={1}>
                          <div
                            className={styles.ImageSmall}
                            style={{
                              backgroundImage: `url(${item.photos[3]})`,
                            }}
                          ></div>
                        </Col>
                      </Row>
                    </Col>
                  </Row>
                )}
              </Col>
            );
          })}
        </Row>
      </div>
    </Page>
  );
}

export default memo(TripPage);
